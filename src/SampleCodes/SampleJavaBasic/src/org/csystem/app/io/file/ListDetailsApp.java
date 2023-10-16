package org.csystem.app.io.file;

import org.csystem.util.console.Console;

import java.io.File;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ListDetailsApp {
    private static String getPath(String [] args)
    {
        if (args.length == 0)
            return Console.readString("Input path:");

        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        return args[0];
    }

    private static void doForDirectory(File dir)
    {
        for (File f : dir.listFiles()) {
            String name = f.getName();

            if (f.isDirectory())
                Console.writeLine("%s <DIR>", name);
            else if (f.isFile())
                Console.writeLine("%s %d", name, f.length());
            else
                Console.writeLine(name);
        }
    }

    public static void run(String [] args)
    {
        try {
            File file = new File(getPath(args));

            if (file.exists())
                if (file.isDirectory())
                    doForDirectory(file);
                else
                    Console.writeLine("Path is not a directory!...");
            else
                Console.writeLine("Invalid path!...");
        }
        catch (SecurityException ignore) {
            System.err.println("Security problem occurs!...");
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
