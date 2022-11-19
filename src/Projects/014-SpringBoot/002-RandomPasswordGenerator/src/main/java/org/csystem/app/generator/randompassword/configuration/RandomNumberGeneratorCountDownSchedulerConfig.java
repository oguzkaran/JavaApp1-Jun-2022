package org.csystem.app.generator.randompassword.configuration;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.countdown.CountDownScheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Configuration
public class RandomNumberGeneratorCountDownSchedulerConfig {
    private final Random m_random;

    @Value("${app.random.count}")
    private int m_count;

    @Value("${app.scheduler.interval}")
    private long m_interval;

    public RandomNumberGeneratorCountDownSchedulerConfig(Random random)
    {
        m_random = random;
    }

    @Bean("numberGeneratorScheduler")
    public CountDownScheduler getScheduler(@Value("${app.random.min}") int min, @Value("${app.random.max}") int max)
    {
        return new CountDownScheduler(m_count, m_interval, TimeUnit.SECONDS) {
            @Override
            protected void onTick(long millisUntilFinished) throws Exception
            {
                Console.writeLine("%d", m_random.nextInt(min, max + 1));
            }

            @Override
            protected void onFinish() throws Exception
            {
                Console.writeLine("Finished");
            }
        };
    }
}
