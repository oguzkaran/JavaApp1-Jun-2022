package org.csystem.app.service.animalhospital.scheduler.configuration.data.datasourceproperties;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalDataSourcePropertiesConfig {
    @Bean("spring.datasource.animal")
    @ConfigurationProperties("spring.datasource.animal")
    public DataSourceProperties veterinarianDataSourceProperties()
    {
        return new DataSourceProperties();
    }
}
