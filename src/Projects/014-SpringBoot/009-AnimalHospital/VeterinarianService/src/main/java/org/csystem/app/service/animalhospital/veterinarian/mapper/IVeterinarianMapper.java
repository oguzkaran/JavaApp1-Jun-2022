package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.Veterinarian;
import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;

import java.util.List;

public interface IVeterinarianMapper {
    VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian);

    default VeterinariansDTO toVeterinariansDTO(List<VeterinarianDTO> veterinarians)
    {
        var dto = new VeterinariansDTO();

        dto.veterinarians = veterinarians;

        return dto;
    }
    default CountDTO toCountDTO(long count)
    {
        return new CountDTO(count);
    }
}
