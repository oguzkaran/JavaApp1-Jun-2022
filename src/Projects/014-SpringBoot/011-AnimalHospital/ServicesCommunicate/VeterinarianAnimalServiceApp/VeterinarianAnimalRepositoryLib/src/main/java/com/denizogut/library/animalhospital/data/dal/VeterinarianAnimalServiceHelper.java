package com.denizogut.library.animalhospital.data.dal;

import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import com.denizogut.library.animalhospital.data.entity.backup.VeterinarianAnimalBackup;
import com.denizogut.library.animalhospital.data.repository.IVeterinarianAnimalBackupRepository;
import com.denizogut.library.animalhospital.data.repository.IVeterinarianAnimalRepository;
import com.karandev.util.data.repository.exception.RepositoryException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Lazy
public class VeterinarianAnimalServiceHelper {
    private final IVeterinarianAnimalRepository m_veterinarianRepository;

    private final IVeterinarianAnimalBackupRepository m_veterinarianAnimalBackupRepository;


    public VeterinarianAnimalServiceHelper(IVeterinarianAnimalRepository m_veterinarianRepository, IVeterinarianAnimalBackupRepository m_veterinarianAnimalBackupRepository) {
        this.m_veterinarianRepository = m_veterinarianRepository;
        this.m_veterinarianAnimalBackupRepository = m_veterinarianAnimalBackupRepository;
    }

    public VeterinarianAnimal saveVeterinarianAnimal(VeterinarianAnimal veterinarianAnimalSave)
    {
        try {
            veterinarianAnimalSave.uuid = UUID.randomUUID();
            return m_veterinarianRepository.save(veterinarianAnimalSave);
        }
        catch (Throwable ex) {
            throw new RepositoryException("VeterinarianAnimalServiceHelper.saveVeterinarianAnimal", ex);
        }
    }

    public VeterinarianAnimalBackup saveVeterinarianAnimalBackup(VeterinarianAnimalBackup veterinarianAnimalBackupSave)
    {
        try {
            return m_veterinarianAnimalBackupRepository.save(veterinarianAnimalBackupSave);
        }
        catch (Throwable ex) {
            throw new RepositoryException("VeterinarianAnimalServiceHelper.saveVeterinarianAnimalBackup", ex);
        }
    }

    public Iterable<VeterinarianAnimal> findAllVeterinarianAnimal()
    {
        return m_veterinarianRepository.findAll();
    }

    public void deleteVeterinarianAnimalByUUID(UUID uuid)
    {
        m_veterinarianRepository.deleteById(uuid);
    }
}
