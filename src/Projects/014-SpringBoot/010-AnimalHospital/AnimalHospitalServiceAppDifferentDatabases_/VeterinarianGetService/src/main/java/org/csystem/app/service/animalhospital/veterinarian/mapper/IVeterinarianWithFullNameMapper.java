package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianWithFullName;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianWithFullNameDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithFullNameDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "VeterinarianWithFullNameMapperImpl", componentModel = "spring")
public interface IVeterinarianWithFullNameMapper {
    VeterinarianWithFullNameDTO toVeterinarianWithFullName(VeterinarianWithFullName veterinarianWithFullName);

    default VeterinariansWithFullNameDTO toVeterinariansDTO(List<VeterinarianWithFullNameDTO> veterinarians)
    {
        var dto = new VeterinariansWithFullNameDTO();

        dto.veterinarians = veterinarians;

        return dto;
    }
}
