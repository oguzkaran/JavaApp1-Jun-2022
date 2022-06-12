/*----------------------------------------------------------------------------------------------------------------------
    n-inci Fibonacci sayısını döndüren fibonacciNumber metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.Util;

public class FibonacciNumberTest {
    public static void run()
    {
        for (;;) {
            var n = Console.readInt("Input a number:");

            if (n <= 0)
                break;

            var val = Util.fibonacciNumber(n);

            Console.writeLine("%d. Fibonacci sayısı:%d", n, Util.fibonacciNumber(n));
        }
    }
}
