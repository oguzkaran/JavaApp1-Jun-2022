package org.csystem.app.service.animalhospital.owner.mapper;

import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import org.csystem.app.service.animalhospital.owner.dto.AnimalDTO;
import org.csystem.app.service.animalhospital.owner.dto.OwnerDTO;
import org.csystem.app.service.animalhospital.owner.dto.OwnersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "OwnerMapperImpl", componentModel = "spring")
public interface IOwnerMapper {
    OwnerDTO toOwnerDTO(Owner owner);
    AnimalDTO toAnimalDTO(Animal animal);

    default OwnersDTO toOwnersDTO(List<OwnerDTO> owners)
    {
        var dto = new OwnersDTO();

        dto.owners = owners;

        return dto;
    }
}
