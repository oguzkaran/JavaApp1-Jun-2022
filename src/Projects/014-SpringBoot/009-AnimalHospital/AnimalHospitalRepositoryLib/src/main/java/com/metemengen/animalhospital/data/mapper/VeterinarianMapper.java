package com.metemengen.animalhospital.data.mapper;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianSave;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.VETERINARIAN_MAPPER)
public class VeterinarianMapper implements IVeterinarianMapper {
    @Override
    public Veterinarian toVeterinarian(VeterinarianSave veterinarianSave)
    {
        var vetSave = new Veterinarian();

        vetSave.diplomaNo = veterinarianSave.diplomaNo;
        vetSave.citizenId = veterinarianSave.citizenId;
        vetSave.firstName = veterinarianSave.firstName;
        vetSave.middleName = Optional.ofNullable(veterinarianSave.middleName);
        vetSave.lastName = veterinarianSave.lastName;
        vetSave.birthDate = veterinarianSave.birthDate;
        vetSave.registerDate = veterinarianSave.registerDate;

        return vetSave;
    }
}
