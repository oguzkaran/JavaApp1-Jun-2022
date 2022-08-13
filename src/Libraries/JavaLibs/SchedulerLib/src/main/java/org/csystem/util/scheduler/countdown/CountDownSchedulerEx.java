/*----------------------------------------------------------------------
	FILE        : CountDownSchedulerEx.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 13.08.2022

	CountdownSchedulerEx class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler.countdown;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public abstract class CountDownSchedulerEx extends CountDownScheduler {
    protected CountDownSchedulerEx(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, MILLISECONDS);
    }

    protected CountDownSchedulerEx(long durationInFuture, long interval, TimeUnit timeUnit)
    {
        super(durationInFuture, interval, timeUnit);
    }

    protected abstract void onStart();

    public final CountDownSchedulerEx startScheduler()
    {
        onStart();
        start();

        return this;
    }

}
