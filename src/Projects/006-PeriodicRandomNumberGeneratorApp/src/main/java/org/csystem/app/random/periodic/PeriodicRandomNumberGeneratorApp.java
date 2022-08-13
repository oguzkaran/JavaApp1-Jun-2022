package org.csystem.app.random.periodic;

import org.csystem.util.console.Console;
import org.csystem.util.random.generator.IIntConsumer;
import org.csystem.util.random.generator.IIntSupplier;
import org.csystem.util.random.generator.PeriodicIntGenerator;

import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class PeriodicRandomNumberGeneratorApp {
    private static IIntSupplier getSupplier(Random random, int min, int bound)
    {
        return new IIntSupplier() { // İleride değiştireceğiz
            public int get()
            {
                return random.nextInt(min, bound);
            }
        };
    }

    private static IIntConsumer getConsumer()
    {
        return new IIntConsumer() { // İleride değiştireceğiz
            public void accept(int a)
            {
                Console.write("%d ", a);
            }
        };
    }

    public static void run(String [] args)
    {
        try {
            checkLengthEquals(args.length, 5, "Wrong number of Arguments", 2);
            var random = new Random();
            var min = Integer.parseInt(args[1]);
            var bound = Integer.parseInt(args[2]);
            new PeriodicIntGenerator(Integer.parseInt(args[0]), Long.parseLong(args[3]),
                    Long.parseLong(args[4]), getSupplier(random, min, bound))
                    .start(getConsumer());
        }
        catch (NumberFormatException ex) {
            Console.Error.writeLine("Invalid values");
        }
    }
}
