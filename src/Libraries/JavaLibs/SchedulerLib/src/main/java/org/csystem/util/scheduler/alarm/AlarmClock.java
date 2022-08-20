/*----------------------------------------------------------------------
	FILE        : AlarmClock.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 14.08.2022

	Alarm class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler.alarm;

import org.csystem.util.scheduler.IRunnable;
import org.csystem.util.scheduler.Scheduler;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static org.csystem.util.scheduler.alarm.AlarmClockStatus.ONCE;
public class AlarmClock {
    private final Scheduler m_scheduler;
    private final LocalTime m_time;

    private void scheduleCallback(IRunnable alarmTask, IRunnable periodTask, AlarmClockStatus alarmClockStatus)
    {
        try {
            if (periodTask != null)
                periodTask.run();

            var now = LocalTime.now();

            now = now.withNano(0);
            if (now.equals(m_time))
                if (alarmClockStatus == ONCE)
                    m_scheduler.cancel();
                else
                    alarmTask.run();
        }
        catch (Exception ignore) {

        }
    }

    public AlarmClock(LocalTime time)
    {
        m_scheduler = new Scheduler(1, TimeUnit.SECONDS);
        m_time = time;
    }

    public AlarmClock(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public AlarmClock(int hour, int minute, int second)
    {
        this(LocalTime.of(hour, minute, second));
    }

    public AlarmClock start(IRunnable alarmTask, AlarmClockStatus alarmClockStatus)
    {
        return start(alarmTask, null, alarmClockStatus);
    }

    public AlarmClock start(IRunnable alarmTask)
    {
        return start(alarmTask, null, ONCE);
    }

    public AlarmClock start(IRunnable alarmTask, IRunnable periodTask)
    {
        return start(alarmTask, periodTask, ONCE);
    }

    public AlarmClock start(IRunnable alarmTask, IRunnable periodTask, AlarmClockStatus alarmClockStatus)
    {
        m_scheduler.schedule(() -> scheduleCallback(alarmTask, periodTask, alarmClockStatus), alarmTask);
        return this;
    }

    public void cancel()
    {
        m_scheduler.cancel();
    }
}
