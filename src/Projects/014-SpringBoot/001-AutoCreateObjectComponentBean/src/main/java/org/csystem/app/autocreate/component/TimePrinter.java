package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component("atahan")
@Scope("prototype")
public class TimePrinter {
    public TimePrinter()
    {
        Console.writeLine("TimePrinter.TimePrinter");
    }

    @PostConstruct
    public void printTime()
    {
        var formatter = DateTimeFormatter.ofPattern("kk:mm:ss");

        Console.writeLine("Now:%s", formatter.format(LocalTime.now()));
    }
}
