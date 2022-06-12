/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersten yazdıran writeReverse metodunun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.RecursionUtil;
import org.csystem.util.recursion.Util;

public class RecursiveWriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Input a text:");

            RecursionUtil.writeReverse(s);
            Console.writeLine();

            if ("quit".equals(s))
                break;
        }
    }
}
