/*----------------------------------------------------------------------------------------------------------------------
   Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının 1(bir) olan bitlerinin indeks numaralarını int türden bir dizi
   olarak döndüren indicesOfSetBits metodunu BitwiseUtil sınıfı içerisinde yazınız ve aşağıdaki kod ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.bitwise.BitwiseUtil;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        IndicesOfSetBitsTest.run();
    }
}

class IndicesOfSetBitsTest {
    public static void run()
    {
        for (;;) {
            var a = Console.readShort("Bir sayı giriniz:");

            Console.writeLine(BitwiseUtil.toBitsStr(a));

            ArrayUtil.print(BitwiseUtil.indicesOfSetBits(a));

            if (a == 0)
                break;
        }
    }
}

