package org.csystem.app.service.animalhospital.scheduler.service;

import com.denizogut.library.animalhospital.data.dal.VeterinarianAnimalServiceHelper;
import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import com.karandev.util.data.repository.exception.RepositoryException;
import org.csystem.app.service.animalhospital.scheduler.dto.client.ExistsDTO;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.stream.StreamSupport;

@Service
public class VeterinarianSchedulerService {
    private final VeterinarianAnimalServiceHelper m_veterinarianAnimalServiceHelper;

    private final RestTemplate m_restTemplate;

    @Value("${rest.veterinarian.exists.diploma}")
    private String m_veterinarianServiceUrlFormat;

    @Value("${rest.animal.exists.id}")
    private String m_animalServiceUrlFormat;

    private boolean exists(String url)
    {
        var existsDTO = m_restTemplate.getForObject(url, ExistsDTO.class);

        return existsDTO != null && existsDTO.exists;
    }

    private boolean veterinarianExists(VeterinarianAnimal veterinarianAnimal)
    {
        return exists(String.format(m_veterinarianServiceUrlFormat, veterinarianAnimal.diplomaNo));
    }

    private boolean animalExists(VeterinarianAnimal veterinarianAnimal)
    {
        return exists(String.format(m_animalServiceUrlFormat, veterinarianAnimal.animalId));
    }

    public VeterinarianSchedulerService(VeterinarianAnimalServiceHelper veterinarianAnimalServiceHelper, RestTemplate restTemplate)
    {
        m_veterinarianAnimalServiceHelper = veterinarianAnimalServiceHelper;
        m_restTemplate = restTemplate;
    }

    @Transactional
    public void checkExistence()
    {
        StreamSupport.stream(m_veterinarianAnimalServiceHelper.findAllVeterinarianAnimal().spliterator(), false)
                .forEach(this::check);
    }

    public void check(VeterinarianAnimal veterinarianAnimal)
    {
        try {
            if (!veterinarianExists(veterinarianAnimal) || !animalExists(veterinarianAnimal))
                Console.writeLine("Diploma No:%d, Animal Id:%d", veterinarianAnimal.diplomaNo, veterinarianAnimal.animalId);
        }
        catch (RepositoryException ignore) {

        }
    }

    public Iterable<VeterinarianAnimal> findVeterinarianAnimals()
    {
        return m_veterinarianAnimalServiceHelper.findAllVeterinarianAnimal();
    }

    //...
}
