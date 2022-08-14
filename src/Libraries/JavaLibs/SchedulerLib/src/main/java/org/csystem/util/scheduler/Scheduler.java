/*----------------------------------------------------------------------
	FILE        : Scheduler.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 14.08.2022

	Scheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.concurrent.TimeUnit;

public class Scheduler {
    public Scheduler(long delay, long period)
    {
        this(delay, period, TimeUnit.MILLISECONDS);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        //TODO:
    }

    public Scheduler schedule(Runnable runnable)
    {
        return schedule(runnable, null);
    }

    public Scheduler schedule(Runnable runnable, Runnable cancelRunnable)
    {
        //TODO:

        return this;
    }

    public final void cancel()
    {
        //TODO:
    }
}
