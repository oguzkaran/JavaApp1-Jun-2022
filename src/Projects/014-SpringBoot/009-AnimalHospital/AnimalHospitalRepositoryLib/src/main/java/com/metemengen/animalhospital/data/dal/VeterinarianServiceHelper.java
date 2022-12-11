package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.repository.IVeterinarianRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.VETERINARIAN_SERVICE_HELPER)
public class VeterinarianServiceHelper {
    private final IVeterinarianRepository m_veterinarianRepository;

    public VeterinarianServiceHelper(@Qualifier(BeanName.VETERINARIAN_REPOSITORY) IVeterinarianRepository m_veterinarianRepository)
    {
        this.m_veterinarianRepository = m_veterinarianRepository;
    }

    public long countVeterinarians()
    {
        //...

        return m_veterinarianRepository.count();
    }

    public Optional<Veterinarian> findVeterinarianById(Long diplomaNo)
    {
        //...
        return m_veterinarianRepository.findById(diplomaNo);
    }

    public Iterable<Veterinarian> findVeterinariansByLastName(String lastName)
    {
        //...
        return m_veterinarianRepository.findByLastName(lastName);
    }

    public Iterable<Veterinarian> findVeterinariansByMonthAndYear(int month, int year)
    {
        //...
        return m_veterinarianRepository.findByMonthAndYear(month, year);
    }

    public Veterinarian save(Veterinarian veterinarian)
    {
        return m_veterinarianRepository.save(veterinarian);
    }
}
