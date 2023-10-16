package org.csystem.app.io.file.input;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadByteArrayWithSkipApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            fis.skip(Integer.parseInt(args[2]));
            byte [] data = new byte[Integer.parseInt(args[1])];
            int result;

            while ((result = fis.read(data)) > 0)
                ArrayUtil.print(data, 0, result);

            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid length or skip value!...");
        }
        catch (FileNotFoundException ex) {
            Console.writeErrLine("Problem occurs while opening:%s", ex.getMessage());
        }
        catch (SecurityException ex) {
            Console.writeErrLine("Security problem occurs:%s", ex.getMessage());
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
