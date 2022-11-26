package org.csystem.app.generator.randompassword.configuration;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.countdown.CountDownScheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Configuration
public class RandomPasswordGeneratorCountDownSchedulerConfig {
    private final Random m_random;

    @Value("${app.random.count}")
    private int m_count;

    @Value("${app.scheduler.interval}")
    private long m_interval;

    public RandomPasswordGeneratorCountDownSchedulerConfig(Random random)
    {
        m_random = random;
    }

    @Bean
    @Primary
    public CountDownScheduler getScheduler()
    {
        return new CountDownScheduler(m_count, m_interval, TimeUnit.SECONDS) {
            @Override
            protected void onTick(long millisUntilFinished) throws Exception
            {
                Console.writeLine("%s", StringUtil.getRandomTextEN(m_random, m_random.nextInt(5, 15)));
            }

            @Override
            protected void onFinish() throws Exception
            {
                Console.writeLine("Finished");
            }
        };
    }
}
