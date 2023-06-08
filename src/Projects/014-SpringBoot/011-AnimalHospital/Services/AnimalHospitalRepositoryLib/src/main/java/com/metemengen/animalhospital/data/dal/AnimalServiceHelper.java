package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.ANIMAL_SERVICE_HELPER)
@Lazy
public class AnimalServiceHelper {
    private final IAnimalRepository m_animalRepository;

    public AnimalServiceHelper(IAnimalRepository animalRepository)
    {
        m_animalRepository = animalRepository;
    }

    public Optional<Animal> findAnimalById(int id)
    {
        return m_animalRepository.findById(id);
    }

    public Iterable<Animal> findAnimalsByNameContainsAndSterile(String text, boolean sterile)
    {
        return m_animalRepository.findByNameContainsAndSterile(text, sterile);
    }

    public Iterable<IAnimalWithoutOwner> findAnimalsByType(String type)
    {
        return m_animalRepository.findByType(type);
    }

    public Iterable<AnimalOwnerDetails> findAnimalsByName(String name)
    {
        return m_animalRepository.findByName(name);
    }

    public Iterable<AnimalOwnerDetails> findAnimalsByVeterinarianDiplomaNo(long diplomaNo)
    {
        return m_animalRepository.findByVeterinarianDiplomaNo(diplomaNo);
    }

    public Iterable<Animal> findAnimalsByMonthAndYear(int month, int year)
    {
        return m_animalRepository.findByMonthAndYear(month, year);
    }

    public Animal saveAnimal(Animal animal)
    {
        return m_animalRepository.save(animal);
    }

    //...
}
