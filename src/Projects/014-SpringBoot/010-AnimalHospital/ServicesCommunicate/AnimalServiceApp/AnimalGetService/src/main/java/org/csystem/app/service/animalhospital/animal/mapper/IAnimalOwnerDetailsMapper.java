package org.csystem.app.service.animalhospital.animal.mapper;

import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AnimalOwnerDetailsMapperImpl", componentModel = "spring")
public interface IAnimalOwnerDetailsMapper {
    default AnimalsOwnerDetailsDTO toAnimalsOwnerDetailsDTO(List<AnimalOwnerDetails> animalOwnerDetailsDTOS)
    {
        var dto = new AnimalsOwnerDetailsDTO();

        dto.animals = animalOwnerDetailsDTOS;

        return dto;
    }
}
