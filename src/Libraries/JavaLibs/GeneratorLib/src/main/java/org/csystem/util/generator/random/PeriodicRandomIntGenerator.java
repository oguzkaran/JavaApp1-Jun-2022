/*----------------------------------------------------------------------
	FILE        : PeriodicRandomIntGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 14.08.2022

	PeriodicRandomIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.generator.random;

import org.csystem.util.generator.PeriodicIntGenerator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class PeriodicRandomIntGenerator extends PeriodicIntGenerator {
    private int m_min;
    private int m_bound;
    private Random m_random;

    private PeriodicRandomIntGenerator(Random random, int count, int min, int bound, long delay, long period)
    {
        super(count, delay, period, TimeUnit.MILLISECONDS, null);
        m_random = random;
        m_min = min;
        m_bound = bound;
    }

    public static class Builder {
        private final PeriodicRandomIntGenerator m_generator;

        public Builder()
        {
            m_generator = new PeriodicRandomIntGenerator(new Random(), 10, 0, 99, 0, 1000);

            m_generator.setSupplier(() -> m_generator.m_random.nextInt(m_generator.m_bound - m_generator.m_min) + m_generator.m_min);
        }

        public Builder setRandom(Random random)
        {
            m_generator.m_random = random;

            return this;
        }

        public Builder setCount(int count)
        {
            m_generator.setCount(count);

            return this;
        }

        public Builder setMin(int min)
        {
            m_generator.m_min = min;

            return this;
        }

        public Builder setBound(int bound)
        {
            m_generator.m_bound = bound;

            return this;
        }

        public Builder setDelay(long delay)
        {
            m_generator.setDelay(delay);

            return this;
        }

        public Builder setPeriod(long period)
        {
            m_generator.setPeriod(period);

            return this;
        }

        public PeriodicRandomIntGenerator build()
        {
            return m_generator;
        }
    }
}
