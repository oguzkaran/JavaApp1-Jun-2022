package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadLinesFileStreamApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0]);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))) {
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
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
