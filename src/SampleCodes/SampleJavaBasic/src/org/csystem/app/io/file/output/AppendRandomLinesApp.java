package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomLinesApp {
    private static void writeLines(BufferedWriter bw, int count, int min, int bound) throws IOException
    {
        Random random = new Random();
        try (bw) {
            while (count-- > 0) {
                String text = StringUtil.getRandomTextTR(random, random.nextInt(min, bound));

                bw.write(text);
                bw.newLine();
            }
        }
    }
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 4, "Wrong number of arguments!...");

        try {
            int count = Integer.parseInt(args[1]);
            int min = Integer.parseInt(args[2]);
            int bound = Integer.parseInt(args[3]);
            BufferedWriter bw = Files.newBufferedWriter(Path.of(args[0]), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            writeLines(bw, count, min, bound);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid number value(s)!...");
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
