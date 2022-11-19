package org.csystem.app.generator.randompassword.configuration.runner;

import org.csystem.util.scheduler.countdown.CountDownScheduler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomNumberGeneratorRunner {
    private final CountDownScheduler m_countDownScheduler;

    public RandomNumberGeneratorRunner(@Qualifier("numberGeneratorScheduler") CountDownScheduler countDownScheduler)
    {
        m_countDownScheduler = countDownScheduler;
    }

    @Bean
    public ApplicationRunner run(@Value("${app.random.count}")int count, @Value("${app.scheduler.interval}")long interval)
    {
        return args -> m_countDownScheduler.start();
    }
}
