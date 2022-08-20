/*----------------------------------------------------------------------
	FILE        : Scheduler.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 20.08.2022

	Scheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Scheduler {
    private final long m_delay;
    private final long m_period;
    private Timer m_timer;
    private Runnable m_cancelTask;

    public Scheduler(long period)
    {
        this(0, period);
    }

    public Scheduler(long delay, long period)
    {
        this(delay, period, TimeUnit.MILLISECONDS);
    }

    public Scheduler(long period, TimeUnit timeUnit)
    {
        this(0, period, timeUnit);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        m_delay = timeUnit == MILLISECONDS ? delay : MILLISECONDS.convert(delay, timeUnit);
        m_period = timeUnit == MILLISECONDS ? period : MILLISECONDS.convert(period, timeUnit);
    }

    public Scheduler schedule(Runnable task)
    {
        return schedule(task, null);
    }

    public Scheduler schedule(Runnable task, Runnable cancelTask)
    {
        try {
            m_timer = new Timer();
            m_cancelTask = cancelTask;
            m_timer.schedule(new TimerTask() {
                @Override
                public void run()
                {
                    task.run();
                }
            }, m_delay, m_period);

            return this;
        }
        catch (Throwable ex) {
            if (m_timer != null)
                m_timer.cancel();
            throw ex;
        }
    }

    public final void cancel()
    {
        m_timer.cancel();

        if (m_cancelTask != null)
            m_cancelTask.run();
    }
}
