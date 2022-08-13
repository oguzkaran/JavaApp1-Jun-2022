package org.csystem.app.random.periodic;

import org.csystem.util.console.Console;
import org.csystem.util.random.generator.IIntConsumer;
import org.csystem.util.random.generator.PeriodicRandomIntGenerator;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class PeriodicRandomNumberGeneratorApp {
    public static void run(String []args)
    {
        try {
            checkLengthEquals(args.length, 5, "Wrong number of Arguments");
            new PeriodicRandomIntGenerator.Builder()
                    .setCount(Integer.parseInt(args[0]))
                    .setMin(Integer.parseInt(args[1]))
                    .setBound(Integer.parseInt(args[2]))
                    .setDelay(Long.parseLong(args[3]))
                    .setPeriod(Long.parseLong(args[4]))
                    .build().start(new IIntConsumer() { // İleride değiştireceğiz
                        public void accept(int a)
                        {
                            Console.write("%d ", a);
                        }
                    });
        }
        catch (NumberFormatException ex) {
            Console.Error.writeLine("Invalid values");
        }
    }
}
