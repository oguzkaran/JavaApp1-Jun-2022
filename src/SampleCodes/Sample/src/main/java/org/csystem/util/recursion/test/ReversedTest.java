/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı ters yüz eden reversed metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.Util;

public class ReversedTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Input a text:");

            var rev = Util.reversed(s);
            Console.writeLine(rev);

            if ("quit".equals(s))
                break;
        }
    }
}
