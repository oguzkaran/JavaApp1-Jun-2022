package org.csystem.app.service.animalhospital.veterinarian.service;

import com.karandev.util.data.repository.exception.RepositoryException;
import com.karandev.util.data.service.DataServiceException;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianSaveMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VeterinarianService {
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianSaveMapper m_veterinarianSaveMapper;

    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper veterinarianServiceHelper,
                               IVeterinarianSaveMapper veterinarianSaveMapper)
    {
        m_veterinarianServiceHelper = veterinarianServiceHelper;
        m_veterinarianSaveMapper = veterinarianSaveMapper;
    }

    public VeterinarianSaveDTO saveVeterinarian(VeterinarianSaveDTO veterinarianSaveDTO)
    {
        try {
            m_veterinarianServiceHelper.saveVeterinarian(m_veterinarianSaveMapper.toVeterinarianSave(veterinarianSaveDTO));

            return veterinarianSaveDTO;
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("VeterinarianService.saveVeterinarian", ex.getCause());
        }
    }

    //...
}
