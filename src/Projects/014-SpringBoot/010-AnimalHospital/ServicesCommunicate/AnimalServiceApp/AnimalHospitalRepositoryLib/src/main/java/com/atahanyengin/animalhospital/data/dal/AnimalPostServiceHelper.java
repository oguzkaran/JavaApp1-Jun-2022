package com.atahanyengin.animalhospital.data.dal;

import com.atahanyengin.animalhospital.data.entity.orm.Owner;
import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import com.atahanyengin.animalhospital.data.mapper.IAnimalDTOMapper;
import com.atahanyengin.animalhospital.data.repository.orm.IAnimalRepository;
import com.atahanyengin.animalhospital.data.repository.orm.IOwnerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Lazy
public class AnimalPostServiceHelper {
    private final IAnimalRepository m_animalRepository;
    private final IOwnerRepository m_ownerRepository;

    private  final IAnimalDTOMapper m_animalMapper;

    private void saveAnimalWithOwnerActionCallback(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO, Owner owner)
    {
        var animal = m_animalMapper.toAnimal(animalWithOwnerSaveDTO);

        animal.owner = owner;
        m_animalRepository.save(animal);
        animalWithOwnerSaveDTO.id = animal.id;
    }

    private void saveAnimalWithOwnerEmptyActionCallback(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        var owner = new Owner();

        owner.name = animalWithOwnerSaveDTO.ownerName;
        owner.phone = animalWithOwnerSaveDTO.phone;
        owner.address = animalWithOwnerSaveDTO.address;
        owner = m_ownerRepository.save(owner);
        saveAnimalWithOwnerActionCallback(animalWithOwnerSaveDTO, owner);
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

        opt.ifPresentOrElse(o -> saveAnimalWithOwnerActionCallback(animalWithOwnerSaveDTO, o),
                () -> saveAnimalWithOwnerEmptyActionCallback(animalWithOwnerSaveDTO));

        return animalWithOwnerSaveDTO;
    }

    @Transactional
    public AnimalSaveDTO saveAnimal(AnimalSaveDTO animalSaveDTO)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
