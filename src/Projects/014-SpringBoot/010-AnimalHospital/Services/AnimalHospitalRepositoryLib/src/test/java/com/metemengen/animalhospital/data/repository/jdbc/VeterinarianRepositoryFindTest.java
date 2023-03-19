package com.metemengen.animalhospital.data.repository.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@SpringBootApplication
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql({"/ddl.sql", "/veterinarian_data.sql"})
public class VeterinarianRepositoryFindTest {
    @Autowired
    private IVeterinarianRepository m_veterinarianRepository;

    @Test
    public void givenDiplomaNo_whenFindById_thenOptionalPresent()
    {
        var diplomaNo = 1976L;
        var vetOpt = m_veterinarianRepository.findById(diplomaNo);

        Assertions.assertTrue(vetOpt.isPresent());
    }

    @Test
    public void givenDiplomaNo_whenFindById_thenOptionalEmpty()
    {
        var diplomaNo = 2021L;
        var vetOpt = m_veterinarianRepository.findById(diplomaNo);

        Assertions.assertTrue(vetOpt.isEmpty());
    }

}
