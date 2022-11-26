package org.csystem.app.greeting.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Scope("prototype")
@RequestMapping("/api/greetings/greeting")
public class GreetingController {
    private final LocalDateTime m_localDateTime;
    private final DateTimeFormatter m_formatter;

    public GreetingController(LocalDateTime localDateTime, DateTimeFormatter formatter)
    {
        m_localDateTime = localDateTime;
        m_formatter = formatter;
    }

    //@RequestMapping(value = "/tr", method = RequestMethod.GET)
    @GetMapping("tr")
    public String helloTR(String name, @RequestParam("sname") String surname)
    {
        return String.format("Merhaba, %s %s -> %s", name, surname, m_localDateTime.format(m_formatter));
    }

    @GetMapping("en")
    public String helloEN(String name, @RequestParam("sname") String surname)
    {
        return String.format("Hello, %s %s -> %s", name, surname, m_localDateTime.format(m_formatter));
    }
}
