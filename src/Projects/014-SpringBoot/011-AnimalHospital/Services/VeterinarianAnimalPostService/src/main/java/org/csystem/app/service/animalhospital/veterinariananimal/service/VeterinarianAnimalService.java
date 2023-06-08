package org.csystem.app.service.animalhospital.veterinariananimal.service;

import com.metemengen.animalhospital.data.dal.VeterinarianAnimalServiceHelper;
import org.csystem.app.service.animalhospital.veterinariananimal.dto.VeterinarianAnimalSaveDTO;
import org.csystem.app.service.animalhospital.veterinariananimal.mapper.IVeterinarianAnimalMapper;
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
        return m_veterinarianAnimalServiceHelper.saveVeterinarianAnimal(m_veterinarianAnimalMapper.toVeterinarianAnimalSave(veterinarianAnimalSaveDTO));
    }
}
