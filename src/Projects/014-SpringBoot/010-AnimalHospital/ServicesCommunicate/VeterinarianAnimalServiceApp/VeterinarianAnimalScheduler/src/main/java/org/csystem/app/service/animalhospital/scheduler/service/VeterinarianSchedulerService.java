package org.csystem.app.service.animalhospital.scheduler.service;

import com.denizogut.library.animalhospital.data.dal.VeterinarianAnimalServiceHelper;
import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import com.karandev.util.data.repository.exception.RepositoryException;
import org.csystem.app.service.animalhospital.scheduler.dto.client.ExistsDTO;
import org.csystem.app.service.animalhospital.scheduler.mapper.IVeterinarianAnimalMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class VeterinarianSchedulerService {
    private final VeterinarianAnimalServiceHelper m_veterinarianAnimalServiceHelper;
    private final IVeterinarianAnimalMapper m_veterinarianAnimalMapper;

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

    private void check(VeterinarianAnimal veterinarianAnimal)
    {
        try {
            if (!veterinarianExists(veterinarianAnimal) || !animalExists(veterinarianAnimal)) {
                m_veterinarianAnimalServiceHelper.deleteVeterinarianAnimalByUUID(veterinarianAnimal.uuid);
                var backup = m_veterinarianAnimalMapper.toVeterinarianAnimalBackup(veterinarianAnimal);

                m_veterinarianAnimalServiceHelper.saveVeterinarianAnimalBackup(backup);
            }
        }
        catch (RepositoryException ignore) {

        }
    }

    public VeterinarianSchedulerService(VeterinarianAnimalServiceHelper m_veterinarianAnimalServiceHelper,
                                        IVeterinarianAnimalMapper m_veterinarianAnimalMapper,
                                        RestTemplate m_restTemplate) {
        this.m_veterinarianAnimalServiceHelper = m_veterinarianAnimalServiceHelper;
        this.m_veterinarianAnimalMapper = m_veterinarianAnimalMapper;
        this.m_restTemplate = m_restTemplate;
    }

    @Transactional
    public void checkExistence()
    {
        StreamSupport.stream(m_veterinarianAnimalServiceHelper.findAllVeterinarianAnimal().spliterator(), false)
                .forEach(this::check);
    }

    public Iterable<VeterinarianAnimal> findVeterinarianAnimals()
    {
        return m_veterinarianAnimalServiceHelper.findAllVeterinarianAnimal();
    }

    public void deleteVeterinarianAnimalByUUID(UUID uuid)
    {
        m_veterinarianAnimalServiceHelper.deleteVeterinarianAnimalByUUID(uuid);
    }

    //...
}
