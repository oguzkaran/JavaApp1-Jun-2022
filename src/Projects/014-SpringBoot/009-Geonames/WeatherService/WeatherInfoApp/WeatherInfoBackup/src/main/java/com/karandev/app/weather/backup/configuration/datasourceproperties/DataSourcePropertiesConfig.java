package com.karandev.app.weather.backup.configuration.datasourceproperties;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourcePropertiesConfig {
    @Bean("spring.datasource.weatherinfo")
    @ConfigurationProperties("spring.datasource.weatherinfo")
    public DataSourceProperties weatherInfoDataProperties()
    {
        return new DataSourceProperties();
    }
}
