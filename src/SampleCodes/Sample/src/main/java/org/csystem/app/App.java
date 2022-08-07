/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Yukarıdaki örneği aşağıdaki gibi çalıştırılabilecek şekilde yazınız:
        java -jar PeriodicRandomNumberGenerator-6.0.0.jar count min max period
    Çözüm için ~/Projects/006-PeriodicRandomNumberGeneratorApp uygulamasına bakınız

    Sınıf Çalışması: Aşağıda aç
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var count = Console.readInt("Kaç tane sayı üretmek istersiniz?");
        var timer = new Timer();
        var random = new Random();

        timer.scheduleAtFixedRate(new TimerTask() {
            private int m_count;

            public void run()
            {
                if (m_count++ != count)
                    Console.write("%02d ", random.nextInt(100));
                else
                    timer.cancel();
            }
        }, 0, 1000);
    }
}

