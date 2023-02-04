package org.csystem.app.service.animalhospital.veterinarian.configuration;

import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {
    @Bean
    @Primary
    public IVeterinarianMapper getMapper()
    {
        return Mappers.getMapper(IVeterinarianMapper.class);
    }
}
