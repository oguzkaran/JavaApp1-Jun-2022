package org.csystem.app.generator.randompassword.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class RandomConfig {
    @Bean
    @Scope("prototype")
    public Random createRandom(@Value("${app.random.seed:0}")long seed)
    {
        return seed == 0 ? new Random() : new Random(seed);
    }
}
