package com.atahanyengin.animalhospital.data.mapper;

import com.atahanyengin.animalhospital.data.entity.orm.Animal;
import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AnimalDTOMapperImpl", componentModel = "spring")
public interface IAnimalDTOMapper {
    Animal toAnimal(AnimalDTO animalDTO);
}
