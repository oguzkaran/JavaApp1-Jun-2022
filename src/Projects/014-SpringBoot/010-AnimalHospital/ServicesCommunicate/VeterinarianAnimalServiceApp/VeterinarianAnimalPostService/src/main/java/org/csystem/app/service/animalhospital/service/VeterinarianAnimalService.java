package org.csystem.app.service.animalhospital.service;

import com.denizogut.library.animalhospital.data.dal.VeterinarianAnimalServiceHelper;
import com.karandev.util.data.repository.exception.RepositoryException;
import org.csystem.app.service.animalhospital.dto.VeterinarianAnimalSaveDTO;
import org.csystem.app.service.animalhospital.mapper.IVeterinarianAnimalMapper;
import org.springframework.stereotype.Service;

@Service
public class VeterinarianAnimalService {
    private final VeterinarianAnimalServiceHelper m_veterinarianAnimalServiceHelper;
    private final IVeterinarianAnimalMapper m_veterinarianAnimalMapper;

    public VeterinarianAnimalService(VeterinarianAnimalServiceHelper veterinarianAnimalServiceHelper, IVeterinarianAnimalMapper veterinarianAnimalMapper)
    {
        m_veterinarianAnimalServiceHelper = veterinarianAnimalServiceHelper;
        m_veterinarianAnimalMapper = veterinarianAnimalMapper;
    }

    public boolean saveVeterinarianAnimal(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO)
    {
        boolean result = true;

        try {
            m_veterinarianAnimalServiceHelper.saveVeterinarianAnimal(m_veterinarianAnimalMapper.toVeterinarianAnimalSave(veterinarianAnimalSaveDTO));
        }
        catch (RepositoryException ignore) {
            result = false;
        }

        return result;
    }
}
