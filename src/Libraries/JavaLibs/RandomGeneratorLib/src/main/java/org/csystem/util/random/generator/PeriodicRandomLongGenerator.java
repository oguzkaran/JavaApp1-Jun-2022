/*----------------------------------------------------------------------
	FILE        : PeriodicRandomLongGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 13.08.2022

	PeriodicRandomIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.random.generator;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PeriodicRandomLongGenerator {
    private int m_count;
    private long m_min;
    private long m_bound;
    private long m_delay;
    private long m_period;
    private Timer m_timer;

    private PeriodicRandomLongGenerator(int count, long min, long bound, long delay, long period)
    {
        m_count = count;
        m_min = min;
        m_bound = bound;
        m_delay = delay;
        m_period = period;
    }

    public static class Builder {
        private final PeriodicRandomLongGenerator m_generator;

        public Builder()
        {
            m_generator = new PeriodicRandomLongGenerator(10, 0, 99, 0, 1000);
        }

        public Builder setCount(int count)
        {
            m_generator.m_count = count;

            return this;
        }

        public Builder setMin(long min)
        {
            m_generator.m_min = min;

            return this;
        }

        public Builder setBound(long bound)
        {
            m_generator.m_bound = bound;

            return this;
        }

        public Builder setDelay(long delay)
        {
            m_generator.m_delay = delay;

            return this;
        }

        public Builder setPeriod(long period)
        {
            m_generator.m_period = period;

            return this;
        }

        public PeriodicRandomLongGenerator build()
        {
            return m_generator;
        }
    }

    public void start(ILongConsumer consumer)
    {
        var random = new Random();
        m_timer = new Timer();

        m_timer.scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                if (m_count-- != 0)
                    consumer.accept(Math.abs(random.nextLong()) * (m_bound - m_min) + m_min);
                else
                    m_timer.cancel();
            }
        }, m_delay, m_period);
    }

    public void stop()
    {
        m_timer.cancel();
    }
}
