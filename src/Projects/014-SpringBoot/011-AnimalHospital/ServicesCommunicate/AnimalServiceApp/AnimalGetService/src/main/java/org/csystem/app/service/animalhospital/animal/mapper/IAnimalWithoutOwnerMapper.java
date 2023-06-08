package org.csystem.app.service.animalhospital.animal.mapper;

import com.atahanyengin.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsWithoutOwnerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AnimalWithoutOwnerMapperImpl", componentModel = "spring")
public interface IAnimalWithoutOwnerMapper {

    default AnimalsWithoutOwnerDTO toAnimalsDTO(List<IAnimalWithoutOwner> animals)
    {
        var dto = new AnimalsWithoutOwnerDTO();

        dto.animals = animals;

        return dto;
    }
}
