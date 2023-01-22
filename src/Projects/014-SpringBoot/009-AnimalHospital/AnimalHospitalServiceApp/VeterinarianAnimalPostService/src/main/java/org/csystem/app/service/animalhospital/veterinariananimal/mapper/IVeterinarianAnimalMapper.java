package org.csystem.app.service.animalhospital.veterinariananimal.mapper;

import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import org.csystem.app.service.animalhospital.veterinariananimal.dto.VeterinarianAnimalSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "VeterinarianAnimalMapperImpl", componentModel = "spring")
public interface IVeterinarianAnimalMapper {
    VeterinarianAnimalSave toVeterinarianAnimalSave(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO);
}
