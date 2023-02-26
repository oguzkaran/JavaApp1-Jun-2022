package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.jdbc.Veterinarian;
import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "VeterinarianMapperImpl")
public interface IVeterinarianMapper {
    VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian);
    VeterinarianStatusDTO toVeterinarianStatus(VeterinarianDTO veterinarianDTO); //3 yaklaşımı da göstermek için eklendi

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
