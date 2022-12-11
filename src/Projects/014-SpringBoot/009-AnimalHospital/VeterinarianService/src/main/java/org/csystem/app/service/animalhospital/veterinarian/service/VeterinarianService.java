package org.csystem.app.service.animalhospital.veterinarian.service;

import com.metemengen.animalhospital.data.repository.IVeterinarianRepository;
import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeterinarianService {
    private final IVeterinarianRepository m_veterinarianRepository;
    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianService(IVeterinarianRepository veterinarianRepository,
                               IVeterinarianMapper veterinarianMapper)
    {
        m_veterinarianRepository = veterinarianRepository;
        m_veterinarianMapper = veterinarianMapper;
    }

    public CountDTO countVeterinarians()
    {
        return m_veterinarianMapper.toCountDTO(m_veterinarianRepository.count());
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return m_veterinarianRepository.findById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO);
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianRepository.findByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO));
        //return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianRepository.findByLastName(lastName).spliterator(), false)
          //      .map(m_veterinarianMapper::toVeterinarianDTO).collect(Collectors.toList()));
    }

    //...
}
