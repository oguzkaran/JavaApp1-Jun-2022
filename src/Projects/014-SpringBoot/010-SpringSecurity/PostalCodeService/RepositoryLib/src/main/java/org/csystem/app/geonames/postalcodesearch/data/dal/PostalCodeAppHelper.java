package org.csystem.app.geonames.postalcodesearch.data.dal;

import jakarta.transaction.Transactional;
import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCode;
import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeInfo;
import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeQueryInfo;
import org.csystem.app.geonames.postalcodesearch.data.repository.IPostalCodeInfoRepository;
import org.csystem.app.geonames.postalcodesearch.data.repository.IPostalCodeQueryInfoRepository;
import org.csystem.app.geonames.postalcodesearch.data.repository.IPostalCodeRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostalCodeAppHelper {
    private final IPostalCodeRepository m_postalCodeRepository;
    private final IPostalCodeInfoRepository m_postalCodeInfoRepository;
    private final IPostalCodeQueryInfoRepository m_postalCodeQueryInfoRepository;

    public PostalCodeAppHelper(IPostalCodeRepository postalCodeRepository, IPostalCodeInfoRepository postalCodeInfoRepository, IPostalCodeQueryInfoRepository postalCodeQueryInfoRepository)
    {
        m_postalCodeRepository = postalCodeRepository;
        m_postalCodeInfoRepository = postalCodeInfoRepository;
        m_postalCodeQueryInfoRepository = postalCodeQueryInfoRepository;
    }

    public boolean existPostalCodeInfoByCode(String code)
    {
        return m_postalCodeInfoRepository.existsById(code);
    }

    public Iterable<PostalCode> findPostalCodesByCode(String code)
    {
        return m_postalCodeRepository.findByCode(code);
    }

    public Optional<PostalCodeInfo> findPostalCodeInfoByCode(String code)
    {
        return m_postalCodeInfoRepository.findById(code);
    }
    public int updatePostalCodeInfoQueryCount(String code)
    {
        return m_postalCodeInfoRepository.updateQueryCount(code);
    }

    public PostalCodeInfo savePostalCodeInfo(PostalCodeInfo postalCodeInfo)
    {
        return m_postalCodeInfoRepository.save(postalCodeInfo);
    }

    public PostalCodeQueryInfo savePostalCodeQueryInfo(PostalCodeQueryInfo postalCodeQueryInfo)
    {
        return m_postalCodeQueryInfoRepository.save(postalCodeQueryInfo);
    }
}
