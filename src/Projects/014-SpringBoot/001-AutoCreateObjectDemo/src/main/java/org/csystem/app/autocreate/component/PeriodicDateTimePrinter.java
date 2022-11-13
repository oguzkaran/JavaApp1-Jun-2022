package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class PeriodicDateTimePrinter {
    private final ApplicationContext m_applicationContext;
    private final DateTimeFormatter m_dateTimeFormatter;

    private void schedulerCallback()
    {
        var localDateTime = m_applicationContext.getBean(LocalDateTime.class);

        Console.write("%s\r", m_dateTimeFormatter.format(localDateTime));
    }

    public PeriodicDateTimePrinter(ApplicationContext applicationContext, @Qualifier("com.can.bean.datetime.formatter") DateTimeFormatter dateTimeFormatter)
    {
        m_applicationContext = applicationContext;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @PostConstruct
    public void startScheduler()
    {
        var scheduler = new Scheduler(1, TimeUnit.SECONDS);

        scheduler.schedule(this::schedulerCallback);
    }
}
