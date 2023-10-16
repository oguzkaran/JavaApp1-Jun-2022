package org.csystem.app.io.file.join;

import org.csystem.util.console.Console;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthGreater;

public class AppendFoundFilesApp {
    private static void append(Path path, FileOutputStream fos)
    {
        try {
            Files.copy(path, fos);
        }
        catch (IOException ex) {
            Console.writeErrLine("Source file not found:%s", path);
        }
    }
    public static void run(String[] args)
    {
        checkLengthGreater(args.length, 1, "Wrong number of arguments!...");

        try (FileOutputStream fos = new FileOutputStream(args[args.length - 1], true)) {
            for (int i = 0; i < args.length - 1; ++i)
                append(Path.of(args[i]), fos);

            Console.writeLine("Successful");
        }
        catch (SecurityException ex) {
            Console.writeErrLine("Security problem occurs:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.writeErrLine("I/O problem occurs:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
