package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.karandev.util.mapstruct.IOptionalMapper;
import com.karandev.util.mapstruct.annotation.ToType;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianWithoutCitizenIdDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithoutCitizenIdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(implementationName = "VeterinarianWithoutCitizenIdMapperImpl", componentModel = "spring")
public interface IVeterinarianWithoutCitizenIdMapper extends IOptionalMapper  {
    @Mapping(source = "middleName", target = "middleName", qualifiedBy = ToType.class)
    VeterinarianWithoutCitizenIdDTO toVeterinarianWithoutCitizenIdDTO(VeterinarianWithoutCitizenId veterinarian);

    default VeterinariansWithoutCitizenIdDTO toVeterinariansWithoutCitizenIdDTO(List<VeterinarianWithoutCitizenIdDTO> veterinarians)
    {
        var dto = new VeterinariansWithoutCitizenIdDTO();

        dto.veterinarians = veterinarians;

        return dto;
    }

}
