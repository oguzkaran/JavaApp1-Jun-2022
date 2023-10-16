package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.Console.readString;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendLinesWithBufferSizeApp {
    private static void writeLines(BufferedWriter bw) throws IOException
    {
        try (bw) {
            while (true) {
                String text = readString("Input text:");

                if ("quit".equals(text))
                    break;

                bw.write(text);
                bw.newLine();
            }
        }
    }
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");
        try {
            int bufSize = Integer.parseInt(args[1]);
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[0], StandardCharsets.UTF_8, true), bufSize);

            writeLines(bw);

            Console.readChar();
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid number value for buffer size!...");
        }
        catch (IllegalArgumentException ignore) {
            Console.writeErrLine("Buffer size must be positive!...");
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
