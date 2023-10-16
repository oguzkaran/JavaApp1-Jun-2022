package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadIntsViaScannerApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        int sum = 0;
        try (Scanner scanner = new Scanner(Path.of(args[0]), StandardCharsets.UTF_8)) {
            while (true)
                sum += scanner.nextInt();
        }
        catch (InputMismatchException ignore) {
            Console.writeErrLine("File format problem!...");
        }
        catch (NoSuchElementException ignore) {
            Console.writeLine("Sum:%d", sum);
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
