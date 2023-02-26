package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import com.metemengen.animalhospital.data.repository.jdbc.IVeterinarianRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
@Lazy
public class VeterinarianAnimalServiceHelper {
    private final IVeterinarianRepository m_veterinarianRepository;

    public VeterinarianAnimalServiceHelper(IVeterinarianRepository veterinarianRepository)
    {
        m_veterinarianRepository = veterinarianRepository;
    }

    public boolean saveVeterinarianAnimal(VeterinarianAnimalSave veterinarianAnimalSave)
    {
        return m_veterinarianRepository.saveVeterinarianAnimal(veterinarianAnimalSave);
    }
}
