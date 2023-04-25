package com.karandev.app.weather.backup.configuration.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private final DataSourceProperties m_dataSourceProperties;

    public DataSourceConfig(@Qualifier("spring.datasource.weatherinfo") DataSourceProperties dataSourceProperties)
    {
        m_dataSourceProperties = dataSourceProperties;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.weatherinfo.configuration")
    public DataSource weatherInfoDataSource()
    {
        return m_dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
