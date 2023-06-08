package com.metemengen.animalhospital.data.repository.jdbc;

import com.metemengen.animalhospital.data.entity.jdbc.Veterinarian;
import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianWithFullName;
import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import com.metemengen.animalhospital.data.repository.orm.IOwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.Optional;

//@SpringBootTest
//@SpringBootApplication
@ComponentScan({"com.metemengen"})
@EnableJpaRepositories(basePackages = "com.metemengen")
@EntityScan(basePackages = "com.metemengen")
@TestPropertySource(locations = "classpath:application-test.properties")
public class VeterinarianRepositorySaveVeterinarianAnimalTest {
    @MockBean
    @Qualifier("veterinarianrepository.test")
    private IVeterinarianRepository m_veterinarianRepository;

    @Autowired
    private IOwnerRepository m_ownerRepository;

    @Autowired
    private IAnimalRepository  m_animalRepository;

    @TestConfiguration
    static class VeterinarianRepositoryTestContextConfig {
        @Autowired
        private NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

        @Bean("veterinarianrepository.test")
        public IVeterinarianRepository veterinarianServiceRepository()
        {
            return new VeterinarianRepository(m_namedParameterJdbcTemplate);
        }
    }


    private int m_animalId;

    private static Animal createAnimal(Owner owner)
    {
        var animal = new Animal();

        animal.name = "Ares";
        animal.type = "Dog";
        animal.birthDate = LocalDate.of(2017, 4, 19);
        animal.sterile = false;
        animal.owner = owner;

        return animal;
    }

    private static Owner createOwner()
    {
        var owner = new Owner();

        owner.name = "Buse Bahadır";
        owner.address = "Marmaris";
        owner.phone = "05647876589";

        return owner;
    }

    @BeforeEach
    public void setUp()
    {
        //...
    }

    @Test
    @Sql("/ddl.sql")
    public void givenVeterinarianAnimalSaveInformation_whenSave_thenSuccess()
    {
        var owner = createOwner();

        m_ownerRepository.save(owner);
        var animal = createAnimal(owner);
        m_animalRepository.save(animal);
        m_animalId = animal.id;
        var veterinarianAnimalSave = new VeterinarianAnimalSave();

        veterinarianAnimalSave.diplomaNo = 1234;
        veterinarianAnimalSave.animalId = m_animalId;
        veterinarianAnimalSave.price = 234.6;

        Mockito.when(m_veterinarianRepository.saveVeterinarianAnimal(veterinarianAnimalSave)).thenReturn(true);
    }
}
