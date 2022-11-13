package org.csystem.app.autocreate.component;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component("busra")
public class DatePrinter {
    public DatePrinter()
    {
        Console.writeLine("DatePrinter.DatePrinter");
    }

    @PostConstruct
    public void printDate()
    {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Console.writeLine("Today:%s", formatter.format(LocalDate.now()));
    }
}
