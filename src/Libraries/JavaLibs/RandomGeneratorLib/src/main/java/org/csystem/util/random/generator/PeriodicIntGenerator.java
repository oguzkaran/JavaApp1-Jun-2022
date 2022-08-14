/*----------------------------------------------------------------------
	FILE        : PeriodicIntGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 14.08.2022

	PeriodicIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.random.generator;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class PeriodicIntGenerator {
    private int m_count;
    private long m_delay;
    private long m_period;
    private Timer m_timer;
    private IntSupplier m_supplier;

    public PeriodicIntGenerator(int count, long delay, long period, IntSupplier supplier)
    {
        this(count, delay, period, MILLISECONDS, supplier);
    }

    public PeriodicIntGenerator(int count, long delay, long period, TimeUnit timeUnit, IntSupplier supplier)
    {
        m_count = count;
        m_delay = timeUnit == MILLISECONDS ? delay : MILLISECONDS.convert(delay, timeUnit);
        m_period = timeUnit == MILLISECONDS ? period : MILLISECONDS.convert(period, timeUnit);
        m_supplier = supplier;
    }

    public void setCount(int count)
    {
        m_count = count;
    }

    public void setDelay(long delay)
    {
        m_delay = delay;
    }

    public void setDelay(long delay, TimeUnit timeUnit)
    {
        m_delay = delay;
    }

    public void setPeriod(long period)
    {
        m_period = period;
    }

    public void setPeriod(long period, TimeUnit timeUnit)
    {
        m_period = period;
    }

    public void setSupplier(IntSupplier supplier)
    {
        m_supplier = supplier;
    }

    public void start(IntConsumer consumer)
    {
        var random = new Random();

        m_timer = new Timer();
        m_timer.scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                if (m_count-- != 0)
                    consumer.accept(m_supplier.getAsInt());
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
