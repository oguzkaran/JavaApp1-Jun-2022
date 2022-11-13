package org.csystem.app.autocreate.configuration;

import org.csystem.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {
    @Bean("com.can.bean.datetime.formatter")
    public DateTimeFormatter getDateTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
    }

    @Bean("com.can.bean.datetime.localdatetime")
    @Scope("prototype")
    public LocalDateTime createNow()
    {
        return LocalDateTime.now();
    }
}
