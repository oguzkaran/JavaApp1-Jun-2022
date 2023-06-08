package org.csystem.app.service.animalhospital.service;

import com.denizogut.library.animalhospital.data.dal.VeterinarianAnimalServiceHelper;
import com.karandev.util.data.repository.exception.RepositoryException;
import org.csystem.app.service.animalhospital.dto.VeterinarianAnimalSaveDTO;
import org.csystem.app.service.animalhospital.dto.client.ExistsDTO;
import org.csystem.app.service.animalhospital.mapper.IVeterinarianAnimalMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class VeterinarianAnimalService {
    private final VeterinarianAnimalServiceHelper m_veterinarianAnimalServiceHelper;
    private final IVeterinarianAnimalMapper m_veterinarianAnimalMapper;

    private final RestTemplate m_restTemplate;

    @Value("${rest.veterinarian.exists.diploma}")
    private String m_veterinarianServiceUrlFormat;

    @Value("${rest.animal.exists.id}")
    private String m_animalServiceUrlFormat;

    private boolean exists(String url)
    {
        var existsDTO = m_restTemplate.getForObject(url, ExistsDTO.class);

        return existsDTO != null && existsDTO.exists;
    }

    private boolean veterinarianExists(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO)
    {
        return exists(String.format(m_veterinarianServiceUrlFormat, veterinarianAnimalSaveDTO.diplomaNo));
    }

    private boolean animalExists(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO)
    {
        return exists(String.format(m_animalServiceUrlFormat, veterinarianAnimalSaveDTO.animalId));
    }

    public VeterinarianAnimalService(VeterinarianAnimalServiceHelper veterinarianAnimalServiceHelper, IVeterinarianAnimalMapper veterinarianAnimalMapper, RestTemplate restTemplate)
    {
        m_veterinarianAnimalServiceHelper = veterinarianAnimalServiceHelper;
        m_veterinarianAnimalMapper = veterinarianAnimalMapper;
        m_restTemplate = restTemplate;
    }

    @Transactional
    public boolean saveVeterinarianAnimal(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO)
    {
        boolean result = true;

        try {
            if (!veterinarianExists(veterinarianAnimalSaveDTO))
                return false;

            if (!animalExists(veterinarianAnimalSaveDTO))
                return false;

            m_veterinarianAnimalServiceHelper.saveVeterinarianAnimal(m_veterinarianAnimalMapper.toVeterinarianAnimalSave(veterinarianAnimalSaveDTO));
        }
        catch (RepositoryException ignore) {
            result = false;
        }

        return result;
    }


    //...
}
