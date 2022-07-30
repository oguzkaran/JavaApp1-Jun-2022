/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: UtilLib içerisindeki NumberUtil sınıfına int parametreli ve BigInteger referansına
    geri dönen factorialBig metodunu ekleyiniz ve aşağıdaki ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

class App {
    public static void main(String[] args)
    {
        FactorialBigTest.run();
    }
}

class FactorialBigTest {
    public static void run()
    {
        var n = Console.readInt("Bir sayı giriniz:");


        for (int i = 0; i < n; ++i)
            Console.writeLine("%d! = %s", i, NumberUtil.factorialBig(i));
    }
}