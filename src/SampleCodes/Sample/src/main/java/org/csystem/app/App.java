/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: SchedulerLib içerisinde bildirilen ve aşağıda açıklanan Alarm isimli sınıfı yazınız
    Açıklamalar:
    - Sınıfın bildirimde yazan ctor'ları olacaktır

    - Sınıfın start isimli iki tane metodu olacaktır. Bir tane Runnable parmetreli start metodu zaman geldiğinde yapılacak
    işklemi alacaktır (callback).

    - Sınıfın alarmı iptal eden cancel isimli bir metodu olacaktır

    - Alarm sınıfının yazarken Scheduler sınıfını kullanınız
----------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.alarm.AlarmClock;
import org.csystem.util.scheduler.alarm.AlarmClockStatus;

class App {
    public static void main(String[] args)
    {
        new AlarmClock(14, 28).start(() -> Console.writeLine("Haydi uyan!..."), AlarmClockStatus.DAILY);
    }
}

