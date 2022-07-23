/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfı (dolayısıyla GregorianCalendar sınıfı) tarih-zaman değerleri için geçerlilik kontrolü yapmaz. Geçerli
    olmayan değerleri hesaplayarak (ekleyerek veya çıkartarak) uygun ntarih zamana dönüştürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        var now = new GregorianCalendar(2021, Calendar.SEPTEMBER, 123456, 89, 1);

        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d.%02d",
                now.get(Calendar.DAY_OF_MONTH),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.YEAR),
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                now.get(Calendar.MILLISECOND));


    }
}