package com.metemengen.animalhospital.data.repository.jdbc;

import com.metemengen.animalhospital.data.entity.jdbc.Veterinarian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class VeterinarianRepositorySaveTest {
    @Autowired
    private IVeterinarianRepository m_veterinarianRepository;

    @Test
    @Sql("/ddl.sql")
    public void givenVeterinarianInformationWithMiddleName_whenSave_thenFindByDiplomaNo()
    {
        var v = new Veterinarian(90234328, "12345678912", "Ceyhun", Optional.of("Ersin"), "Eğrek", LocalDate.of(1989, 8, 1), LocalDate.now());

        m_veterinarianRepository.save(v);

        var vetOpt = m_veterinarianRepository.findById(v.diplomaNo);

        Assertions.assertTrue(vetOpt.isPresent());
        Assertions.assertEquals(vetOpt.get().diplomaNo, v.diplomaNo);
    }


    @Test
    @Sql({"/ddl.sql", "/veterinarian_data.sql"})
    public void givenVeterinarianInformationWithoutMiddleName_whenSave_thenFindByDiplomaNo()
    {
        var v = new Veterinarian(90234329, "12345678915", "Nuri", "Öztürk", LocalDate.of(1999, 1, 25), LocalDate.now());

        m_veterinarianRepository.save(v);

        var vetOpt = m_veterinarianRepository.findById(v.diplomaNo);

        Assertions.assertTrue(vetOpt.isPresent());
        Assertions.assertEquals(vetOpt.get().diplomaNo, v.diplomaNo);
    }
}
