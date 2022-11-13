package org.csystem.app.autocreate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {
    @Bean("com.ceyhun.bean.datetime.formatter")
    public DateTimeFormatter getDateTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Bean
    @Scope("prototype")
    public LocalDate createToday()
    {
        return LocalDate.now();
    }
}
