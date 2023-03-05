package org.csystem.app.service.animalhospital.mapper;

import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import org.csystem.app.service.animalhospital.dto.VeterinarianAnimalSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "VeterinarianAnimalMapperImpl", componentModel = "spring")
public interface IVeterinarianAnimalMapper {
    VeterinarianAnimal toVeterinarianAnimalSave(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO);
}
