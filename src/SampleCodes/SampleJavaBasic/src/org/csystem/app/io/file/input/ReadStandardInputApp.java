package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadStandardInputApp {
    public static void run(String[] args)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
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
