/*----------------------------------------------------------------------------------------------------------------------
    OptinalInt sınıfının ifPresentOrElse metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var random = new Random();

        for (;;) {
            var str = Console.read("Bir yazı giriniz:");

            if ("elma".equals(str))
                break;

            var optInt = NumberUtil.toInt(str);

            optInt.ifPresentOrElse(val -> Console.writeLine("%d * %d = %d", val, val, val * val),
                    () -> Console.Error.writeLine("Geçersiz değer!...")); //Since Java 9
        }
    }
}
