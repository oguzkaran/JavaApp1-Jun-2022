package org.csystem.app.service.animalhospital.scheduler.configuration.data.jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nuricanozturk.animalhospital.repository",
            entityManagerFactoryRef = "veterinarianEntityManagerFactory", transactionManagerRef = "veterinarianTransactionManager")
public class VeterinarianJpaConfig {
    @Bean("veterinarianEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean veterinarianEntityManagerFactory(@Qualifier("veterinarianDataSource")DataSource dataSource,
                                                                                   EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        return entityManagerFactoryBuilder.dataSource(dataSource)/*...*/.build();
    }

    @Bean("veterinarianTransactionManager")
    public PlatformTransactionManager veterinarianTransactionManager(
            @Qualifier("veterinarianEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean)
    {
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
    }
}
