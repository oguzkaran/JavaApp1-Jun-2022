package org.csystem.app.service.animalhospital.scheduler.runner;

import org.csystem.app.service.animalhospital.scheduler.service.VeterinarianSchedulerService;
import org.csystem.util.console.Console;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerRunner {
    private final VeterinarianSchedulerService m_veterinarianSchedulerService;


    public SchedulerRunner(VeterinarianSchedulerService veterinarianSchedulerService)
    {
        m_veterinarianSchedulerService = veterinarianSchedulerService;
    }

    //@Scheduled(cron = "0 50 23 1,15 * *", zone="Europe/Istanbul")
    @Scheduled(cron = "0 0-15 18 * * *" , zone="Europe/Istanbul")
    public void schedule()
    {
        Console.writeLine("schedule");
        m_veterinarianSchedulerService.checkExistence();
    }
}
