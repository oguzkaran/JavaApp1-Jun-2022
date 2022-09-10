/*----------------------------------------------------------------------------------------------------------------------
    IntGenerator sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.generator.DoubleGenerator;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var random = new Random();
        var gen = DoubleGenerator.of(10, () -> random.nextDouble(3.4, 5.6));

        for (var a : gen)
            Console.write("%d ", a);

        Console.writeLine();

        for (var a : gen)
            Console.write("%d ", a);

        Console.writeLine();
    }
}

