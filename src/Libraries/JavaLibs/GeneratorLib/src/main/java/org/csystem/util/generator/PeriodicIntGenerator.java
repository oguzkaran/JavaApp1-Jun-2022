/*----------------------------------------------------------------------
	FILE        : PeriodicIntGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 27.08.2022

	PeriodicIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.generator;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class PeriodicIntGenerator {
    private int m_count;
    private long m_delay;
    private long m_period;
    private Timer m_timer;
    private IIntSupplier m_supplier;

    public PeriodicIntGenerator(int count, long delay, long period, IIntSupplier supplier)
    {
        this(count, delay, period, MILLISECONDS, supplier);
    }

    public PeriodicIntGenerator(int count, long delay, long period, TimeUnit timeUnit, IIntSupplier supplier)
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

    public void setSupplier(IIntSupplier supplier)
    {
        m_supplier = supplier;
    }

    public void start(IIntConsumer consumer)
    {
        var random = new Random();

        m_timer = new Timer();
        m_timer.scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                try {
                    if (m_count-- != 0)
                        consumer.accept(m_supplier.getAsInt());
                    else
                        m_timer.cancel();
                }
                catch (Exception ignore) {

                }
            }
        }, m_delay, m_period);
    }

    public void stop()
    {
        m_timer.cancel();
    }
}
