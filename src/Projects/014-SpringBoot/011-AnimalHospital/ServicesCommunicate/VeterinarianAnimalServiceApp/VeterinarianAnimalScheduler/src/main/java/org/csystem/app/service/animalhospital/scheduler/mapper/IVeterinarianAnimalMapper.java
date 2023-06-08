package org.csystem.app.service.animalhospital.scheduler.mapper;

import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import com.denizogut.library.animalhospital.data.entity.backup.VeterinarianAnimalBackup;
import org.mapstruct.Mapper;

@Mapper(implementationName = "VeterinarianAnimalMapperImpl", componentModel = "spring")
public interface IVeterinarianAnimalMapper {
    VeterinarianAnimalBackup toVeterinarianAnimalBackup(VeterinarianAnimal veterinarianAnimal);
}
