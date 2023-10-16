package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.Console.readString;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;
public class AppendLinesApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[0], StandardCharsets.UTF_8, true))) {
            while (true) {
                String text = readString("Input text:");

                if ("quit".equals(text))
                    break;

                bw.write(text);
                bw.newLine();
            }
            Console.readChar();
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
