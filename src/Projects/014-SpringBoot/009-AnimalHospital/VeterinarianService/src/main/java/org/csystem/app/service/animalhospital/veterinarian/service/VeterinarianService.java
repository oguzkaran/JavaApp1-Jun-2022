package org.csystem.app.service.animalhospital.veterinarian.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeterinarianService {
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper m_veterinarianServiceHelper,
                               IVeterinarianMapper m_veterinarianMapper)
    {
        this.m_veterinarianServiceHelper = m_veterinarianServiceHelper;
        this.m_veterinarianMapper = m_veterinarianMapper;
    }

    public CountDTO countVeterinarians()
    {
        return m_veterinarianMapper.toCountDTO(m_veterinarianServiceHelper.countVeterinarians());
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return m_veterinarianServiceHelper.findVeterinarianById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO);
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO));
        //return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName).spliterator(), false)
          //      .map(m_veterinarianMapper::toVeterinarianDTO).collect(Collectors.toList()));
    }
    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year), m_veterinarianMapper::toVeterinarianDTO));
    }

    //...
}
