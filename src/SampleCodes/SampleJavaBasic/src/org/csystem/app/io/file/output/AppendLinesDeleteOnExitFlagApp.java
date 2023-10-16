package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.csystem.util.console.Console.readString;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendLinesDeleteOnExitFlagApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(args[0]), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            new File(args[0]).deleteOnExit();
            while (true) {
                String text = readString("Input text:");

                if ("quit".equals(text))
                    break;

                bw.write(text);
                bw.newLine();
                bw.flush();
            }

        }
        catch (IOException ex) {
            Console.writeErrLine("I/O problem occurs:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.writeErrLine("Problem occurs:%s", ex.getMessage());
        }

        Console.readChar();
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
