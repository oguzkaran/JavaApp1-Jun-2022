package com.metemengen.animalhospital.data.dal;

import com.karandev.util.data.repository.exception.RepositoryException;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import com.metemengen.animalhospital.data.mapper.orm.IAnimalDTOMapper;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import com.metemengen.animalhospital.data.repository.orm.IOwnerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Lazy
public class AnimalPostServiceHelper {
    private final IAnimalRepository m_animalRepository;
    private final IOwnerRepository m_ownerRepository;

    private  final IAnimalDTOMapper m_animalMapper;

    private void saveAnimalActionCallback(AnimalDTO animalDTO, Owner owner)
    {
        var animal = m_animalMapper.toAnimal(animalDTO);

        animal.owner = owner;
        m_animalRepository.save(animal);
        animalDTO.id = animal.id;
    }


    private void saveAnimalWithOwnerEmptyActionCallback(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        var owner = new Owner();

        owner.name = animalWithOwnerSaveDTO.ownerName;
        owner.phone = animalWithOwnerSaveDTO.phone;
        owner.address = animalWithOwnerSaveDTO.address;
        owner = m_ownerRepository.save(owner);
        saveAnimalActionCallback(animalWithOwnerSaveDTO, owner);
    }

    public AnimalPostServiceHelper(IAnimalRepository animalRepository, IOwnerRepository ownerRepository, IAnimalDTOMapper animalMapper)
    {
        m_animalRepository = animalRepository;
        m_ownerRepository = ownerRepository;
        m_animalMapper = animalMapper;
    }

    @Transactional
    public AnimalWithOwnerSaveDTO saveAnimalWithOwner(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        var opt = m_ownerRepository.findByPhone(animalWithOwnerSaveDTO.phone);

        opt.ifPresentOrElse(o -> saveAnimalActionCallback(animalWithOwnerSaveDTO, o),
                () -> saveAnimalWithOwnerEmptyActionCallback(animalWithOwnerSaveDTO));

        return animalWithOwnerSaveDTO;
    }

    @Transactional
    public AnimalSaveDTO saveAnimal(AnimalSaveDTO animalSaveDTO)
    {
        var opt = m_ownerRepository.findByPhone(animalSaveDTO.phone);

        if (opt.isEmpty())
            throw new RepositoryException("No such phone for owner");

        saveAnimalActionCallback(animalSaveDTO, opt.get());

        return animalSaveDTO;
    }
}
