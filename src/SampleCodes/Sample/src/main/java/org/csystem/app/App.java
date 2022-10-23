/*----------------------------------------------------------------------------------------------------------------------
    Soru: Parametresi ile aldığı int türden bir sayının asal olup olmadığını test eden isPrime metodunu performansı
    düşünmeden döngü kullanmadan yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.stream.IntStream;

class App {
    public static void main(String[] args)
    {
        IntStream.range(-10, 100).filter(Util::isPrime).forEach(n -> Console.write("%d ", n));
        Console.writeLine();
    }
}


class Util {
    public static boolean isPrime(int val)
    {
        return val > 1 && IntStream.rangeClosed(2, val / 2).allMatch(i -> val % i != 0);
    }
}
