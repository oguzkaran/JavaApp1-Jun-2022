package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianSave;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import com.metemengen.animalhospital.data.mapper.IVeterinarianMapper;
import com.metemengen.animalhospital.data.repository.IAnimalRepository;
import com.metemengen.animalhospital.data.repository.IVeterinarianRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.VETERINARIAN_SERVICE_HELPER)
public class VeterinarianServiceHelper {
    private final IVeterinarianRepository m_veterinarianRepository;
    private final IAnimalRepository m_animalRepository;

    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianServiceHelper(@Qualifier(BeanName.VETERINARIAN_REPOSITORY) IVeterinarianRepository veterinarianRepository,
                                     @Qualifier(BeanName.ANIMAL_REPOSITORY) IAnimalRepository animalRepository,
                                     @Qualifier(BeanName.VETERINARIAN_MAPPER) IVeterinarianMapper veterinarianMapper)
    {
        m_veterinarianRepository = veterinarianRepository;
        m_animalRepository = animalRepository;
        m_veterinarianMapper = veterinarianMapper;
    }

    public long countVeterinarians()
    {
        //...

        return m_veterinarianRepository.count();
    }

    public Optional<Veterinarian> findVeterinarianById(Long diplomaNo)
    {
        //...
        return m_veterinarianRepository.findById(diplomaNo);
    }

    public Iterable<Veterinarian> findVeterinariansByLastName(String lastName)
    {
        //...
        return m_veterinarianRepository.findByLastName(lastName);
    }

    public Iterable<Veterinarian> findVeterinariansByMonthAndYear(int month, int year)
    {
        //...
        return m_veterinarianRepository.findByMonthAndYear(month, year);
    }

    public Iterable<VeterinarianWithoutCitizenId> findVeterinariansByYearBetween(int begin, int end)
    {
        //...
        return m_veterinarianRepository.findByYearBetween(begin, end);
    }

    public VeterinarianSave save(VeterinarianSave veterinarianDTO)
    {
        m_veterinarianRepository.save(m_veterinarianMapper.toVeterinarian(veterinarianDTO));

        return veterinarianDTO;
    }

    public Iterable<AnimalOwnerDetails> findAnimalOwnerDetailsByDiplomaNo(long diplomaNo)
    {
        return m_animalRepository.findByDiplomaNo(diplomaNo);
    }
}
