package com.eraytasay.app.menu.plugin;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.reflection.ReflectionUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MenuApp {
    private static void doWorkForMenu(String path) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException
    {
        path = "plugins/" + path;

        for (;;) {
            int i = 1;
            var classes = ReflectionUtil.getImplementedClassesByJars(path, "com.eraytasay.menu.plugin.IMenuPlugin");

            if (!classes.isEmpty()) {
                Console.writeLine("Menu:");
                for (var cls : classes)
                    Console.writeLine("%d.%s", i++, ReflectionUtil.callMethod(cls, "menuText"));

                Console.write("Option:");
                Console.readInt();
                //Menu seçimi yapılacak
            }
            else
                Console.writeLine("Install plugin(s)");
            Console.read("Press ENTER to continue");
        }
    }

    public static void run(String [] args)
    {
        CommandLineArgsUtil.checkLengthGreater(args.length, 1, "Wrong number of arguments", 1);

        try {
            doWorkForMenu(args.length == 1 ? args[0] : ".");
        }
        catch (Exception ignore) {
            ignore.printStackTrace();
            Console.writeLine("Internal problem occurs");
        }
    }
}
