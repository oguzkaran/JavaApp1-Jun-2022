package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(BeanName.ANIMAL_SERVICE_HELPER)
public class AnimalServiceHelper {
    private final IAnimalRepository m_animalRepository;

    public AnimalServiceHelper(@Qualifier(BeanName.ANIMAL_REPOSITORY) IAnimalRepository animalRepository)
    {
        m_animalRepository = animalRepository;
    }

    public Iterable<AnimalOwnerDetails> findAnimalOwnerDetailsByDiplomaNo(long diplomaNo)
    {
        return m_animalRepository.findByDiplomaNo(diplomaNo);
    }
    //...
}
