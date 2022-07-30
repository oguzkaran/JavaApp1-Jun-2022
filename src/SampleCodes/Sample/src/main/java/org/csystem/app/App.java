/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;

class App {
    public static void main(String[] args)
    {
        IsPrimeTest.run();
    }
}

class IsPrimeTest {
    public static void run()
    {
        var n = Console.readLong("Bir sayı giriniz:");

        Console.writeLine(NumberUtil.isPrime(BigInteger.valueOf(n)) ? "Asal" : "Asal değil");
        Console.writeLine(NumberUtil.isPrime(n) ? "Asal" : "Asal değil");
    }
}