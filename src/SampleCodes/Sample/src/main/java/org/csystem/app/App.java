/*----------------------------------------------------------------------------------------------------------------------
    Comparator arayüzünün compareDouble metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.math.Complex;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

class App {
    public static void main(String[] args)
    {
        var complexSet = new TreeSet<>(Comparator.comparingDouble(Complex::getLength));
        var r = new Random();
        var count = Console.readInt("Bir sayı giriniz:");

        for (int i = 0; i < count; ++i) {
            var a = r.nextDouble(-10, 10);
            var b = r.nextDouble(1, 10);
            var f = new Complex(a, b);

            Console.writeLine("%s -> %s", f, complexSet.add(f));
        }

        Console.writeLine("---------------------------------------------");


        Console.writeLine(complexSet);
        Console.writeLine("Size:%d", complexSet.size());
    }
}