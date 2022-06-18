/*----------------------------------------------------------------------------------------------------------------------
   Parametresi ile aldığı iki sayının ortak bölenlerinin en büyüğünü bulan metodun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.RecursionUtil;

public class RecursiveGCDTest {
    public static void run()
    {
        for (;;) {
            var a = Console.readInt("Birinci sayıyı giriniz:");

            if (a == 0)
                break;

            var b = Console.readInt("İkinci sayıyı giriniz:");

            Console.writeLine("OBEB:%d", RecursionUtil.gcd(a, b));
        }
    }
}
