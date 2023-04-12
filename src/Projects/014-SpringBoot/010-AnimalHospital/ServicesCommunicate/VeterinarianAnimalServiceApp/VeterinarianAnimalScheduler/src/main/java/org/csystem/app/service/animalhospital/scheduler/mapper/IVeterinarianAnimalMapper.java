package org.csystem.app.service.animalhospital.scheduler.mapper;

import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import org.mapstruct.Mapper;

@Mapper(implementationName = "VeterinarianAnimalMapperImpl", componentModel = "spring")
public interface IVeterinarianAnimalMapper {
    VeterinarianAnimal toVeterinarianAnimalSave(VeterinarianAnimal veterinarianAnimalSaveDTO);
}
