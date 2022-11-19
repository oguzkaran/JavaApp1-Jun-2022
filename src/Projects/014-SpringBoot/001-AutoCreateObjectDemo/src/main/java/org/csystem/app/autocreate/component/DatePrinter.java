package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component("busra")
public class DatePrinter {
    private final LocalDate m_localDate;
    private final DateTimeFormatter m_dateTimeFormatter;

    @Value("${datetime.message.dateprinter:bugün}")
    private String m_message;

    public DatePrinter(LocalDate localDate, @Qualifier("com.ceyhun.bean.datetime.formatter") DateTimeFormatter dateTimeFormatter) //ctor injection
    {
        m_localDate = localDate;
        m_dateTimeFormatter = dateTimeFormatter;
    }


    @PostConstruct
    public void printDate()
    {
        Console.writeLine("%s:%s", m_message, m_dateTimeFormatter.format(m_localDate));
    }
}
