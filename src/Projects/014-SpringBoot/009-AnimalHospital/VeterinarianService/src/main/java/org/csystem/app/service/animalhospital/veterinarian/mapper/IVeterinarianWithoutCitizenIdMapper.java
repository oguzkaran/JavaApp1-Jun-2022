package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianWithoutCitizenIdDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithoutCitizenIdDTO;

import java.util.List;

public interface IVeterinarianWithoutCitizenIdMapper {
    VeterinarianWithoutCitizenIdDTO toVeterinarianWithoutCitizenIdDTO(VeterinarianWithoutCitizenId veterinarian);

    default VeterinariansWithoutCitizenIdDTO toVeterinariansWithoutCitizenIdDTO(List<VeterinarianWithoutCitizenIdDTO> veterinarians)
    {
        var dto = new VeterinariansWithoutCitizenIdDTO();

        dto.veterinarians = veterinarians;

        return dto;
    }
}
