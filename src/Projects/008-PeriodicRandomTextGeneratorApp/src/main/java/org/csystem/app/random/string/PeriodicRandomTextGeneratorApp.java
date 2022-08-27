package org.csystem.app.random.string;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.random.generator.PeriodicStringGenerator;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class PeriodicRandomTextGeneratorApp {
    private static void doWork(String prefix, int n, int count, long period)
    {
        var random = new Random();
        var generator = new PeriodicStringGenerator(count, 0, period, () -> StringUtil.getRandomTextEN(random, n));

        generator.start(s -> Console.writeLine(prefix + s));
    }

    public static void run(String [] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args.length, 4, "Wrong number of arguments", 1);

        try {
            var prefix = args[0];
            var n = Integer.parseInt(args[1]);
            var count = Integer.parseInt(args[2]);
            var period = Long.parseLong(args[3]);

            doWork(prefix, n, count, period);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
    }
}
