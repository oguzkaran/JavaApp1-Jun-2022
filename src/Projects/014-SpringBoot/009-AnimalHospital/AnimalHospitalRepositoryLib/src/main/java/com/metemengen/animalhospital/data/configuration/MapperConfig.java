package com.metemengen.animalhospital.data.configuration;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.mapper.IVeterinarianMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(BeanName.MAPPER_CONFIG)
public class MapperConfig {
    @Bean(BeanName.VETERINARIAN_MAPPER)
    public IVeterinarianMapper getVeterinarianMapper()
    {
        return Mappers.getMapper(IVeterinarianMapper.class);
    }
}
