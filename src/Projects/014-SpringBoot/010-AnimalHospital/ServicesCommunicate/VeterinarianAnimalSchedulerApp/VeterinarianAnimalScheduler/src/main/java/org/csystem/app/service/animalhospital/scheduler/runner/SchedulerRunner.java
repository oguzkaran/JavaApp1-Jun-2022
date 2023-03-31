package org.csystem.app.service.animalhospital.scheduler.runner;

import org.csystem.util.console.Console;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerRunner {
    //@Scheduled(cron = "0 50 23 1,15 * *", zone="Europe/Istanbul")
    @Scheduled(cron = "0 1 18 * * FRI" , zone="Europe/Istanbul")
    public void schedule()
    {
        Console.writeLine("Schedule");
    }
}
