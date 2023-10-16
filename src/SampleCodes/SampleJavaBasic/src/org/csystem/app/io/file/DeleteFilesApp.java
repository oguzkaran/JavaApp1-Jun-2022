package org.csystem.app.io.file;

import org.csystem.util.console.Console;

import java.io.File;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class DeleteFilesApp {
    private static void doForDirectory(File dir)
    {
        for (File f : dir.listFiles())
            if (!f.isDirectory())
                f.delete();
    }

    public static void run(String [] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments!...");
            File file = new File(args[0]);

            if (file.exists())
                if (file.isDirectory())
                    doForDirectory(file);
                else
                    Console.writeLine("Path is not a directory!...");
            else
                Console.writeErrLine("Invalid path!...");
        }
        catch (SecurityException ignore) {
            Console.writeErrLine("Security problem occurs!...");
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
