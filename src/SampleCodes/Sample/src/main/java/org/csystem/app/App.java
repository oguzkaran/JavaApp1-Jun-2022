/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: UtilLib içerisindeki NumberUtil sınıfına BigInteger parametreli isPrime metodunbu ekleyiniz ve
    aşağıdaki kod ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;

class App {
    public static void main(String[] args)
    {
        FactorialBigTest.run();
    }
}

class FactorialBigTest {
    public static void run()
    {
        var n = Console.readBigInteger("Bir sayı giriniz:");

        for (var i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
            if (NumberUtil.isPrime(i))
                Console.writeLine("%s ", i);
    }
}