package org.csystem.app.service.animalhospital.owner.mapper;

import com.metemengen.animalhospital.data.entity.OwnerAnimalDetails;
import org.csystem.app.service.animalhospital.owner.dto.OwnersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "OwnerMapperImpl", componentModel = "spring")
public interface IOwnerMapper {
    default OwnersDTO toOwnersDTO(List<OwnerAnimalDetails> owners)
    {
        var dto = new OwnersDTO();

        dto.owners = owners;

        return dto;
    }
}
