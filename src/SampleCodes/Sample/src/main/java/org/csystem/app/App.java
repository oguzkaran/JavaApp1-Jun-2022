/*----------------------------------------------------------------------------------------------------------------------
    BitwiawUtil sınıfının highestSetBit metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.bitwise.BitwiseUtil;
import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        for (;;) {
            var a = Console.readInt("Bir sayı giriniz:");

            BitwiseUtil.writeBits(a);
            Console.writeLine("Highest set bit index:%d", BitwiseUtil.highestSetBit(a));

            if (a == 0)
                break;
        }
    }
}
