/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.RecursionUtil;

public class RecursiveFactorialTest {
    public static void run()
    {
        for (var n = 0; n < 13; ++n)
            Console.writeLine("%d!=%d", n, RecursionUtil.factorial(n));
    }
}
