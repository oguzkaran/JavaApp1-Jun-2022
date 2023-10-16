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

public class AppendLinesTempFileDeleteOnCloseApp {
    public static void run(String[] args)
    {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(File.createTempFile("csd", ".txt", new File(".")).getAbsolutePath()),
                StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.DELETE_ON_CLOSE)) {
            while (true) {
                String text = readString("Input text:");

                if ("quit".equals(text))
                    break;

                bw.write(text);
                bw.newLine();
                bw.flush();
            }
            Console.readChar();
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
