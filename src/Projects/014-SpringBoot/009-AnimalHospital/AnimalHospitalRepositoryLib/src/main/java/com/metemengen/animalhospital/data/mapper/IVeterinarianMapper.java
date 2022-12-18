package com.metemengen.animalhospital.data.mapper;

import com.karandev.util.mapstruct.IOptionalMapper;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "VeterinarianMapperImpl")
public interface IVeterinarianMapper extends IOptionalMapper {
    @Mapping(source = "middleName", target = "middleNameOpt", qualifiedByName = "toOptional")
    @Mapping(source = "middleName", target = "middleName", ignore = true)
    Veterinarian toVeterinarian(VeterinarianSave veterinarianSave);
}
