package com.metemengen.animalhospital.data.dal;


import com.karandev.util.data.repository.exception.RepositoryException;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import com.metemengen.animalhospital.data.repository.orm.IOwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@SpringBootTest
@SpringBootApplication
@ComponentScan({"com.metemengen"})
@EnableJpaRepositories(basePackages = "com.metemengen")
@EntityScan(basePackages = "com.metemengen")
@TestPropertySource(locations = "classpath:application-test.properties")
public class AnimalPostServiceHelperSaveTest {
    @Autowired
    private AnimalPostServiceHelper m_animalPostServiceHelper;

    @Autowired
    private IAnimalRepository m_animalRepository;

    @Autowired
    private IOwnerRepository m_ownerRepository;

    private static AnimalWithOwnerSaveDTO createAnimalWithOwnerSaveDTO()
    {
        var dto = new AnimalWithOwnerSaveDTO();

        dto.name = "Alex";
        dto.type = "Dog";
        dto.birthDate = LocalDate.of(2019, 3, 19);
        dto.sterile = true;
        dto.ownerName = "Güray Sönmez";
        dto.phone = "+905325551245";
        dto.address = "Bodrum";

        return dto;
    }

    private static AnimalSaveDTO createAnimalSaveDTO()
    {
        var dto = new AnimalSaveDTO();

        dto.name = "Boby";
        dto.type = "Cat";
        dto.birthDate = LocalDate.of(2018, 4, 19);
        dto.sterile = false;
        dto.phone = "(739) 9092396";

        return dto;
    }

    private static Owner createOwner()
    {
        var owner = new Owner();

        owner.name = "Buse Bahadır";
        owner.address = "Marmaris";
        owner.phone = "05647876589";

        return owner;
    }

    private static AnimalSaveDTO createAnimalSaveDTOWithOwner(Owner owner)
    {
        var dto = new AnimalSaveDTO();

        dto.name = "Ares";
        dto.type = "Dog";
        dto.birthDate = LocalDate.of(2012, 4, 19);
        dto.sterile = false;
        dto.phone = owner.phone;

        return dto;
    }

    @Test
    @Sql({"/ddl.sql"})
    public void givenAnimalWithOwnerSaveDTOOwnerExists_whenSave_thenFindByAnimalId()
    {
        var owner = createOwner();

        m_ownerRepository.save(owner);
        var dto = createAnimalSaveDTOWithOwner(owner);
        m_animalPostServiceHelper.saveAnimal(dto);

        Assertions.assertTrue(m_animalRepository.existsById(dto.id));
    }

    @Test
    @Sql({"/ddl.sql"})
    public void givenAnimalWithOwnerSaveDTOOwnerNotExists_whenSave_thenFindByAnimalId()
    {
        var dto = createAnimalWithOwnerSaveDTO();

        m_animalPostServiceHelper.saveAnimalWithOwner(dto);

        Assertions.assertTrue(m_animalRepository.existsById(dto.id));
    }

    @Test
    @Sql({"/ddl.sql", "/owner_data.sql"})
    public void givenAnimalSaveDTOInformation_whenSave_thenFindByAnimalId()
    {
        var dto = createAnimalSaveDTO();

        m_animalPostServiceHelper.saveAnimal(dto);

        Assertions.assertTrue(m_animalRepository.existsById(dto.id));
    }

    @Test
    @Sql({"/ddl.sql"})
    public void givenAnimalSaveDTOInformation_whenSave_throwsRepositoryException()
    {
        var dto = createAnimalSaveDTO();

        Assertions.assertThrows(RepositoryException.class, () -> m_animalPostServiceHelper.saveAnimal(dto), "No throw RepositoryException");
    }
}

