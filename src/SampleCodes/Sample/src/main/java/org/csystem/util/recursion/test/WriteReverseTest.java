/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersten yazdıran writeReverse metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.Util;

public class WriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Input a text:");

            Util.writeReverse(s);
            Console.writeLine();

            if ("quit".equals(s))
                break;
        }
    }
}
