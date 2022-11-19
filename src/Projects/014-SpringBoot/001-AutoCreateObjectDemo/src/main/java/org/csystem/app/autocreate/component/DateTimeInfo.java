package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")
public class DateTimeInfo {
    private final LocalDateTime m_localDateTime;
    private final DateTimeFormatter m_dateTimeFormatter;

    @Value("${datetime.message.datetimeinfo}")
    private String m_message;

    public DateTimeInfo(LocalDateTime localDateTime, @Qualifier("com.can.bean.datetime.formatter") DateTimeFormatter dateTimeFormatter) //ctor injection
    {
        m_localDateTime = localDateTime;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @PostConstruct
    public void printDateTime()
    {
        Console.writeLine("%s:%s", m_message, m_dateTimeFormatter.format(m_localDateTime));
    }
}
