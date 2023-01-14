package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.VeterinarianSave;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "VeterinarianSaveMapperImpl", componentModel = "spring")
public interface IVeterinarianSaveMapper {
    VeterinarianSave toVeterinarianSave(VeterinarianSaveDTO veterinarianSaveDTO);
}
