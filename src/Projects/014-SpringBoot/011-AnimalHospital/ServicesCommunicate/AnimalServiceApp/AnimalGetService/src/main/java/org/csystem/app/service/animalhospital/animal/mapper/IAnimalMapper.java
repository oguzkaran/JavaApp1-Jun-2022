package org.csystem.app.service.animalhospital.animal.mapper;

import com.atahanyengin.animalhospital.data.entity.orm.Animal;
import org.csystem.app.service.animalhospital.animal.dto.AnimalDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AnimalMapperImpl", componentModel = "spring")
public interface IAnimalMapper {
    AnimalDTO toAnimalDTO(Animal animal);

    default AnimalsDTO toAnimalsDTO(List<AnimalDTO> animals)
    {
        var dto = new AnimalsDTO();

        dto.animals = animals;

        return dto;
    }
}
