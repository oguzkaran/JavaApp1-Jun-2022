/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırı argümanı olarak alınan gün, ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "Geçmiş doğum gününüz kutlu olsun", o gün doğum günü ise "Doğum gününüz kutlu olsun", doğum günü henüz gelmemiş
    ise "Doğum gününüzü şimdiden kutlarız" mesajlarından birisini stdout'a bastıran progrtamı yazınız. Programı
    Calendar ve GregorianCalendar sınıfları ile yazınız.
    ~/Projects/004-BirthDateRemainderConsoleAppCalendar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        for (var arg : args)
            Console.writeLine(arg);
    }
}