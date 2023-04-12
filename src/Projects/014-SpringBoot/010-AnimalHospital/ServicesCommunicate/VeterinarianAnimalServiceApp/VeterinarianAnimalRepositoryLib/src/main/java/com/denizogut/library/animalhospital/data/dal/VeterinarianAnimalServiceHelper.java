package com.denizogut.library.animalhospital.data.dal;

import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import com.denizogut.library.animalhospital.data.repository.IVeterinarianAnimalRepository;
import com.karandev.util.data.repository.exception.RepositoryException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class VeterinarianAnimalServiceHelper {
    private final IVeterinarianAnimalRepository m_veterinarianRepository;

    public VeterinarianAnimalServiceHelper(IVeterinarianAnimalRepository veterinarianRepository)
    {
        m_veterinarianRepository = veterinarianRepository;
    }

    public VeterinarianAnimal saveVeterinarianAnimal(VeterinarianAnimal veterinarianAnimalSave)
    {
        try {
            return m_veterinarianRepository.save(veterinarianAnimalSave);
        }
        catch (Throwable ex) {
            throw new RepositoryException("VeterinarianAnimalServiceHelper.saveVeterinarianAnimal", ex);
        }
    }

    public Iterable<VeterinarianAnimal> findAllVeterinarianAnimal()
    {
        return m_veterinarianRepository.findAll();
    }
}
