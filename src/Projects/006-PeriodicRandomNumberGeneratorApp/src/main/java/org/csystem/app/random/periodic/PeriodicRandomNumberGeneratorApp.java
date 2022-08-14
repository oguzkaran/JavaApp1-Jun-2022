package org.csystem.app.random.periodic;

import org.csystem.util.console.Console;
import org.csystem.util.random.generator.PeriodicIntGenerator;

import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class PeriodicRandomNumberGeneratorApp {
    public static void run(String [] args)
    {
        try {
            checkLengthEquals(args.length, 5, "Wrong number of Arguments", 2);
            var random = new Random();
            var min = Integer.parseInt(args[1]);
            var bound = Integer.parseInt(args[2]);
            new PeriodicIntGenerator(Integer.parseInt(args[0]), Long.parseLong(args[3]), Long.parseLong(args[4]), () -> random.nextInt(min, bound))
                    .start(a -> Console.write("%d ", a));
        }
        catch (NumberFormatException ex) {
            Console.Error.writeLine("Invalid values");
        }
    }
}
