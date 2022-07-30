/*----------------------------------------------------------------------------------------------------------------------
   assert statement:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.datetime.stopwatch.StopWatch;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        IsPrimeTest.run();
    }
}

class IsPrimeTest {
    public static void run()
    {
        var random = new Random();
        var stopWatch = new StopWatch();
        var nBits = Console.readInt("Kaç bitlik bir asal sayı üretilsin?");
        var val = BigInteger.probablePrime(nBits, random);

        Console.writeLine("val = %s", val);

        stopWatch.start();
        Console.writeLine(NumberUtil.isPrime(val) ? "Asal" : "Asal değil");
        stopWatch.stop();
        Console.writeLine("Elapsed (sec):%f", stopWatch.totalSeconds());
    }
}
