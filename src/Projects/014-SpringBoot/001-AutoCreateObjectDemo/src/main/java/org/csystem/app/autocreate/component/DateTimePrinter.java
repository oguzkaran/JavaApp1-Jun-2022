package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("baris")
public class DateTimePrinter {
    private DateTimeInfo m_dateTimeInfo;

    //...

    @Value("${datetime.message.dateprinter:Şimdi}")
    private String m_message;

    @Autowired
    public void setDateTimeInfo(DateTimeInfo dateTimeInfo) //setter injection
    {
        //...
        m_dateTimeInfo = dateTimeInfo;
    }

    @PostConstruct
    public void printDateTime()
    {
        Console.writeLine(m_message);
        m_dateTimeInfo.printDateTime();
    }
}
