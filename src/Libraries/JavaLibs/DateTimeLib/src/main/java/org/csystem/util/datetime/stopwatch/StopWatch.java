/*----------------------------------------------------------------------
	FILE        : StopWatch.java
	AUTHOR      : Oğuz Karan, JavaApp1-Jun-2022 group
	LAST UPDATE : 30.07.2022

	StopWatch class to measure time

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime.stopwatch;

import java.util.concurrent.TimeUnit;

public class StopWatch {
    private long m_start;
    private long m_stop;

    public long getStart()
    {
        return m_start;
    }

    public long getStop()
    {
        return m_stop;
    }

    public void start()
    {
        m_start = System.nanoTime();
    }

    public void stop()
    {
        m_stop = System.nanoTime();
    }

    public long getElapsed(TimeUnit timeUnit)
    {
        return timeUnit.convert(m_stop - m_start, TimeUnit.NANOSECONDS);
    }

    public long getElapsedAsNano()
    {
        return m_stop - m_start;
    }

    public long getElapsedAsMillis()
    {
        return getElapsed(TimeUnit.MILLISECONDS);
    }

    public long getElapsedAsSeconds()
    {
        return getElapsed(TimeUnit.SECONDS);
    }

    public double totalSeconds()
    {
        return getElapsedAsNano() / 1_000_000_000.;
    }

    //...
}
