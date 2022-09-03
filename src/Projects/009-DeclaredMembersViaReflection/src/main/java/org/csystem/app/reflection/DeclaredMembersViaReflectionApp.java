package org.csystem.app.reflection;

import org.csystem.app.randomgenerator.RandomObjectArrayFactory;
import org.csystem.util.console.Console;

import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class DeclaredMembersViaReflectionApp {
    public static void run(String [] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments", 1);
            var count = Integer.parseInt(args[0]);

            var factory = new RandomObjectArrayFactory(new Random());

            for (var obj : factory.getObjects(count)) {
                Console.writeLine("////////////////////////////////////////////////////////////////////////////////////");
                var cls = obj.getClass();
                Console.writeLine(cls.getName());
                ReflectionUtil.printDeclaredMethods(cls);
                ReflectionUtil.printDeclaredFields(cls);
                ReflectionUtil.printDeclaredConstructors(cls);
                Console.writeLine("////////////////////////////////////////////////////////////////////////////////////");
            }
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
    }
}
