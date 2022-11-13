package org.csystem.app.autocreate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class TimeConfig {
    private final LocalDateTime m_localDateTime;

    public TimeConfig(LocalDateTime localDateTime) //ctor injection
    {
        m_localDateTime = localDateTime;
    }

    @Bean("com.deniz.bean.datetime.time.formatter")
    public DateTimeFormatter getDateTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("kk:mm:ss");
    }

    @Bean("com.deniz.bean.datetime.localdatetime")
    @Scope("prototype")
    public LocalTime createNow()
    {
        return m_localDateTime.toLocalTime();
    }
}
