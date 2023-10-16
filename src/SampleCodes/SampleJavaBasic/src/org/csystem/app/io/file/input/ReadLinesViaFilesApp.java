package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadLinesViaFilesApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null)
                Console.writeLine(line);
        }
        catch (FileNotFoundException ignore) {
            Console.writeErrLine("File not found!...");
        }
        catch (IOException ex) {
            Console.writeErrLine("I/O problem occurs:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.writeErrLine("Problem occurs:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
