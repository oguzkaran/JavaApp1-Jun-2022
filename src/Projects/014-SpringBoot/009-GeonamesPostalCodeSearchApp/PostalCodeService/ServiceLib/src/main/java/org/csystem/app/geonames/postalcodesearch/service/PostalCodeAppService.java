package org.csystem.app.geonames.postalcodesearch.service;

import org.csystem.app.geonames.postalcodesearch.api.geonames.service.PostalCodeSearchService;
import org.csystem.app.geonames.postalcodesearch.dto.PostalCodesDTO;
import org.csystem.app.geonames.postalcodesearch.mapper.IPostalCodeMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PostalCodeAppService {
    private final PostalCodeSearchService m_postalCodeSearchService;
    private final IPostalCodeMapper m_postalCodeMapper;

    public PostalCodeAppService(PostalCodeSearchService postalCodeSearchService, IPostalCodeMapper postalCodeMapper)
    {
        m_postalCodeSearchService = postalCodeSearchService;
        m_postalCodeMapper = postalCodeMapper;
    }

    public PostalCodesDTO findPostalCodes(String code, int maxRows)
    {
        return m_postalCodeMapper.toPostalCodesDTO(m_postalCodeSearchService.findPostalCodes(code, maxRows));
    }
}
