package org.csystem.app.service.animalhospital.veterinarian.mapper;

import org.csystem.app.service.animalhospital.veterinarian.data.entity.Veterinarian;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.springframework.stereotype.Component;

@Component
public class VeterinarianMapper implements IVeterinarianMapper {
    @Override
    public VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian)
    {
        var dto = new VeterinarianDTO();

        dto.diplomaNo = veterinarian.diplomaNo;;
        dto.firstName = veterinarian.firstName;
        dto.middleName = veterinarian.middleName.orElse(null);
        dto.lastName = veterinarian.lastName;
        dto.birthDate = veterinarian.birthDate;
        dto.registerDate = veterinarian.registerDate;

        return dto;
    }
}
