/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: CountDownScheduler sınıfını genişletecek şekilde başlangıçta da bir işin yapılabilmesini sağlayan
    onStart abstract metodunun eklendiği CountDownSchedulerEx isimli sınıfı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.countdown.CountDownSchedulerEx;

import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        CountDownSchedulerExTest.run();
    }
}

class CountDownSchedulerExTest {
    public static void run()
    {
        var scheduler = new CountDownSchedulerEx(10, 1, TimeUnit.SECONDS) {
            private int m_count;
            protected void onStart()
            {
                Console.writeLine("Geri sayım başlıyor");
            }
            protected void onTick(long millisUntilFinished)
            {
                ++m_count;
                Console.write("%02d\r", millisUntilFinished / 1000);
            }

            protected void onFinish()
            {
                Console.writeLine("00");
                Console.writeLine("Count:%d", m_count);
                Console.writeLine("Geri sayım tamamlandı");
            }
        }.startScheduler();

        //...
    }
}