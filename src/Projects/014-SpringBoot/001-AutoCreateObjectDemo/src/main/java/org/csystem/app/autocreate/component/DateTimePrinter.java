package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("baris")
public class DateTimePrinter {
    private DateTimeInfo m_dateTimeInfo;

    //...

    @Autowired
    public void setDateTimeInfo(DateTimeInfo dateTimeInfo) //setter injection
    {
        //...
        m_dateTimeInfo = dateTimeInfo;
    }

    @PostConstruct
    public void printDateTime()
    {
        Console.writeLine("DateTime Printer");
        m_dateTimeInfo.printDateTime();
    }
}
