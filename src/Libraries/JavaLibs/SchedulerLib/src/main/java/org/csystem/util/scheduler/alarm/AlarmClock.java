/*----------------------------------------------------------------------
	FILE        : AlarmClock.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 14.08.2022

	Alarm class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler.alarm;

import java.time.LocalTime;

public class AlarmClock {
    public AlarmClock(LocalTime time)
    {
        //TODO:
    }

    public AlarmClock(int hour, int minute)
    {
        //TODO:
    }

    public AlarmClock(int hour, int minute, int second)
    {
        //TODO:
    }

    public AlarmClock start(Runnable alarmTask)
    {
        return start(alarmTask, null);
    }

    public AlarmClock start(Runnable alarmTask, Runnable periodTask)
    {
        //TODO:
        return this;
    }

    public void cancel()
    {
        //TODO:
    }
}
