package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.VeterinarianSave;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "VeterinarianSaveMapperImpl", componentModel = "spring")
public interface IVeterinarianSaveMapper {
    VeterinarianSave toVeterinarianSave(VeterinarianSaveDTO veterinarianSaveDTO);

    default VeterinariansDTO toVeterinariansDTO(List<VeterinarianDTO> veterinarians)
    {
        var dto = new VeterinariansDTO();

        dto.veterinarians = veterinarians;

        return dto;
    }

}
