package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.Console.readString;

public class WriteLinesStandardOutputApp {
    public static void run(String[] args)
    {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8))) {
            while (true) {
                String text = readString("Input text:");

                if ("quit".equals(text))
                    break;

                bw.write(text);
                bw.newLine();
            }
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
