package org.csystem.app.service.animalhospital.animal.mapper;

import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.csystem.app.service.animalhospital.animal.dto.AnimalOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AnimalOwnerDetailsMapperImpl", componentModel = "spring")
public interface IAnimalOwnerDetailsMapper {
    AnimalOwnerDetailsDTO toAnimalOwnerDetailsDTO(AnimalOwnerDetails animalOwnerDetails);

    default AnimalsOwnerDetailsDTO toAnimalsOwnerDetailsDTO(List<AnimalOwnerDetailsDTO> animalOwnerDetailsDTOS)
    {
        var dto = new AnimalsOwnerDetailsDTO();

        dto.animals = animalOwnerDetailsDTOS;

        return dto;
    }
}
