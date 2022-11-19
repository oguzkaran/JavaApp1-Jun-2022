package org.csystem.app.generator.randompassword.runner;

import org.csystem.util.scheduler.countdown.CountDownScheduler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGeneratorRunner implements ApplicationRunner {
    private final CountDownScheduler m_countDownScheduler;

    public RandomPasswordGeneratorRunner(CountDownScheduler countDownScheduler)
    {
        m_countDownScheduler = countDownScheduler;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_countDownScheduler.start();
    }
}
