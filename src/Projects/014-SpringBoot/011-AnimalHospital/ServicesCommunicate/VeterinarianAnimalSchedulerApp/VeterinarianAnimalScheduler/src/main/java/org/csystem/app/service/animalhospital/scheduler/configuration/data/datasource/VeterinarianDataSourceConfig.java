package org.csystem.app.service.animalhospital.scheduler.configuration.data.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class VeterinarianDataSourceConfig {
    private final DataSourceProperties m_dataSourceProperties;

    public VeterinarianDataSourceConfig(@Qualifier("spring.datasource.veterinarian")DataSourceProperties m_dataSourceProperties)
    {
        this.m_dataSourceProperties = m_dataSourceProperties;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.veterinarian.configuration")
    public DataSource veterinarianDataSource()
    {
        return m_dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
