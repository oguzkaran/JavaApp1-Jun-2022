package com.karandev.app.weather.backup.configuration.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BackupDataSourceConfig {
    private final DataSourceProperties m_dataSourceProperties;

    public BackupDataSourceConfig(@Qualifier("spring.datasource.weatherinfo.backup") DataSourceProperties dataSourceProperties)
    {
        m_dataSourceProperties = dataSourceProperties;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.weatherinfo.backup.configuration")
    public DataSource weatherInfoBackupDataSource()
    {
        return m_dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
