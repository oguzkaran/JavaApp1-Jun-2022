/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.Util;

public class FactorialTest {
    public static void run()
    {
        for (var n = 0; n < 13; ++n)
            Console.writeLine("%d!=%d", n, Util.factorial(n));
    }
}
