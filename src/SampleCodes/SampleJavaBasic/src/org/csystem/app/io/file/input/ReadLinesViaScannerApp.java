package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadLinesViaScannerApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (Scanner scanner = new Scanner(Path.of(args[0]), StandardCharsets.UTF_8)) {
            while (true)
                Console.writeLine(scanner.nextLine());
        }
        catch (InputMismatchException ignore) {
            Console.writeErrLine("File format problem!...");
        }
        catch (NoSuchElementException ignore) {
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
