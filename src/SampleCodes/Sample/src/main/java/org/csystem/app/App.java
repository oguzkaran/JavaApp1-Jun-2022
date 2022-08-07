/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıda açıklanan sınıfı yazınız:
    Açıklamalar:
        - Sınıfın ismi CountdownScheduler olacaktır
        - Sınıfın ctor'u milisaniye cinsinden toplam zamanı ve periyot bilgisini alacaktır
            new CountdownScheduler(10000, 1000)
        - Sınıfın onTick ve onFinish isimli abstract metotları olacaktır. onTick metodu her periyotta çağrılacak, onFinish
        metodu ise geri sayım bittiğinde çağrılacaktır
        - onTick metodunun kalan zamanı milisaniye cinsinden veren bir parametresi olacaktır: Örneğin:
            new CountdownScheduler(10000, 1000) {
                protected void onTick(long millisUntilFinished)
                {
                    //Her adımda yapılacak iş. millisUntilFinished içerisinde kalan milisaniye sayısı olacaktır
                }

                protected void onFinish()
                {
                    //Geri sayım bittiğinde yapılacak iş
                }
            }
         - Sınıfın start isimli metodu ile scheduler başlatılacaktır
         - Sınıfın cancel isimli metodu geri sayımı durdurmak için kullanılabilecektir
         - java.util.Timer sınıfını  türetme yapmadan kullanınız
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

