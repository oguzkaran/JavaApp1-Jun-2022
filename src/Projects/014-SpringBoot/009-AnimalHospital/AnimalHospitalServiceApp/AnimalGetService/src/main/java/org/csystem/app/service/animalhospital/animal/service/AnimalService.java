package org.csystem.app.service.animalhospital.animal.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.AnimalServiceHelper;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalMapper;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalOwnerDetailsMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class AnimalService {
    private final AnimalServiceHelper m_animalServiceHelper;
    private final IAnimalOwnerDetailsMapper m_animalOwnerDetailsMapper;

    private final IAnimalMapper m_animalMapper;

    public AnimalService(@Qualifier(BeanName.ANIMAL_SERVICE_HELPER) AnimalServiceHelper animalServiceHelper,
                         IAnimalOwnerDetailsMapper animalOwnerDetailsMapper,
                         IAnimalMapper animalMapper)
    {
        m_animalServiceHelper = animalServiceHelper;
        m_animalOwnerDetailsMapper = animalOwnerDetailsMapper;
        m_animalMapper = animalMapper;
    }

    public AnimalsOwnerDetailsDTO findAnimalsByOwnersByDiplomaNo(@RequestParam("no") long diplomaNo)
    {
        return m_animalOwnerDetailsMapper.toAnimalsOwnerDetailsDTO(toList(m_animalServiceHelper.findAnimalOwnerDetailsByDiplomaNo(diplomaNo),
                m_animalOwnerDetailsMapper::toAnimalOwnerDetailsDTO));
    }

    public AnimalsDTO findAnimalsByNameContainsAndSterile(String text)
    {
        return m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByNameContainsAndSterile(text, true),
                m_animalMapper::toAnimalDTO));
    }

    public AnimalsDTO findAnimalsByType(String type)
    {
        return m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByType(type), m_animalMapper::toAnimalDTO));
    }

    public AnimalsDTO findAnimalsByMonthAndYear(int month, int year)
    {
        return m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByMonthAndYear(month, year), m_animalMapper::toAnimalDTO));
    }
}
