package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component("atahan")
public class TimePrinter {
    @Autowired
    private LocalTime m_localTime; //field injection
    @Autowired
    @Qualifier("com.deniz.bean.datetime.time.formatter")
    private DateTimeFormatter m_dateTimeFormatter; //field injection

    @PostConstruct
    public void printTime()
    {
        Console.writeLine("Now:%s", m_dateTimeFormatter.format(m_localTime));
    }
}
