package org.csystem.app.bigdecimal;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FindMinMaxAvgApp {
    private static void doWorkForBigDecimal(int count)
    {
        var total = Console.readBigDecimal("Input a number:");
        var min = total;
        var max = total;

        for (int i = 1; i < count; ++i) {
            var value = Console.readBigDecimal("Input a number:");

            total = total.add(value);
            if (value.compareTo(min) < 0)
                min = value;

            if (max.compareTo(value) < 0)
                max = value;
        }

        Console.writeLine("Total:%s", total);
        Console.writeLine("Minimum:%s", min);
        Console.writeLine("Maximum:%s", max);
        Console.writeLine("Average:%s", total.divide(BigDecimal.valueOf(count), 20, RoundingMode.HALF_UP));
    }

    public static void run(String [] args)
    {
        CommandLineArgsUtil.checkLengthGreater(args.length, 1, "Wrong number of arguments", 1);

        try {
            int count = args.length == 1 ? Integer.parseInt(args[0]) : Integer.parseInt(Console.read("Input count:"));

            doWorkForBigDecimal(count);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid argument");
        }
    }
}
