package org.csystem.app.geonames.postalcodesearch.service;

import com.karandev.util.data.service.DataServiceException;
import org.csystem.app.geonames.postalcodesearch.api.geonames.service.PostalCodeSearchService;
import org.csystem.app.geonames.postalcodesearch.data.dal.PostalCodeAppHelper;
import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeInfo;
import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeQueryInfo;
import org.csystem.app.geonames.postalcodesearch.data.repository.IPostalCodeInfoRepository;
import org.csystem.app.geonames.postalcodesearch.data.repository.IPostalCodeRepository;
import org.csystem.app.geonames.postalcodesearch.dto.PostalCodesDTO;
import org.csystem.app.geonames.postalcodesearch.mapper.IPostalCodeMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.csystem.util.collection.CollectionUtil.toList;

@Service
@Scope("prototype")
public class PostalCodeAppService {
    private final PostalCodeSearchService m_postalCodeSearchService;
    private final IPostalCodeMapper m_postalCodeMapper;
    private final PostalCodeAppHelper m_postalCodeAppHelper;

    private PostalCodeQueryInfo createPostalCodeQueryInfo(PostalCodeInfo pi, int queryCount)
    {
        var pqi = new PostalCodeQueryInfo();

        pqi.postalCodeInfo = pi;
        pqi.queryDateTime = LocalDateTime.now();
        pqi.queryValue = queryCount;

        return pqi;
    }

    private void savePostalCodeQueryInfo(String code)
    {
        var optPi = m_postalCodeAppHelper.findPostalCodeInfoByCode(code);

        if (optPi.isEmpty())
            throw new DataServiceException("findPostalCodes");

        var pi = optPi.get();

        var pqi = createPostalCodeQueryInfo(pi, pi.queryCount);

        pqi.queryValue = pi.queryCount;

        m_postalCodeAppHelper.savePostalCodeQueryInfo(pqi);
    }

    private PostalCodesDTO getPostalCodeFromGeonames(String code)
    {
        var postalCodesDTO = m_postalCodeMapper.toPostalCodesDTO(m_postalCodeSearchService.findPostalCodes(code));

        if (postalCodesDTO.postalCodes.isEmpty())
            return postalCodesDTO;

        var pi = new PostalCodeInfo();
        var pqi = createPostalCodeQueryInfo(pi, 1);

        pi.code = code;

        var list = postalCodesDTO.postalCodes.stream().map(m_postalCodeMapper::toPostalCode).toList();

        list.forEach(pc -> pc.postalCodeInfo = pi);

        pi.postalCodes = new ArrayList<>(list);

        m_postalCodeAppHelper.savePostalCodeInfo(pi);
        m_postalCodeAppHelper.savePostalCodeQueryInfo(pqi);

        return postalCodesDTO;
    }

    private PostalCodesDTO getPostalCodesFromDB(String code)
    {
        m_postalCodeAppHelper.updatePostalCodeInfoQueryCount(code);
        savePostalCodeQueryInfo(code);
        return m_postalCodeMapper.toPostalCodesDTO(toList(m_postalCodeAppHelper.findPostalCodesByCode(code), m_postalCodeMapper::toPostalCodeDTO));
    }

    public PostalCodeAppService(PostalCodeSearchService postalCodeSearchService, IPostalCodeMapper postalCodeMapper, PostalCodeAppHelper postalCodeAppHelper)
    {
        m_postalCodeSearchService = postalCodeSearchService;
        m_postalCodeMapper = postalCodeMapper;
        m_postalCodeAppHelper = postalCodeAppHelper;
    }

    @Transactional
    public PostalCodesDTO findPostalCodes(String code)
    {
        return m_postalCodeAppHelper.existPostalCodeInfoByCode(code) ? getPostalCodesFromDB(code) : getPostalCodeFromGeonames(code);
    }
}
