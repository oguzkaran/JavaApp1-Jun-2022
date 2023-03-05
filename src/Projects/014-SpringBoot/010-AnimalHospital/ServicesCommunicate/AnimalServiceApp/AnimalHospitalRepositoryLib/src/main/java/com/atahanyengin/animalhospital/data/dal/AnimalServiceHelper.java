package com.atahanyengin.animalhospital.data.dal;

import com.atahanyengin.animalhospital.data.BeanName;
import com.atahanyengin.animalhospital.data.entity.orm.Animal;
import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import com.atahanyengin.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;
import com.atahanyengin.animalhospital.data.repository.orm.IAnimalRepository;
import org.springframework.context.annotation.Lazy;
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


    public boolean existsAnimalByAnimalId(Integer id)
    {
        return m_animalRepository.existsById(id);
    }
    
    public Optional<Animal> findAnimalById(Integer id)
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
        throw new UnsupportedOperationException("TODO");
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
