package com.metemengen.animalhospital.data.mapper;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianSave;
import org.springframework.stereotype.Component;

@Component(BeanName.VETERINARIAN_MAPPER)
public class VeterinarianMapper implements IVeterinarianMapper {
    @Override
    public VeterinarianSave toVeterinarianSave(Veterinarian veterinarian)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Veterinarian toVeterinarian(VeterinarianSave veterinarianSave)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
