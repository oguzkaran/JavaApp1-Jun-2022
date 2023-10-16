package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadBytesWithCRLFApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            int result;
            while ((result = br.read()) != -1) {
                ++count;
                char c = (char)result;

                sb.append(switch (c) {
                    case '\r'-> "CR";
                    case '\n' -> "LF";
                    default -> String.valueOf(c);
                });
            }
            Console.writeLine("%s", sb);
            Console.writeLine("Number of character:%d", count);
        }
        catch (FileNotFoundException ex) {
            Console.writeErrLine("Problem occurs while opening:%s", ex.getMessage());
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
