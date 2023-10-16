package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.csystem.util.console.Console.readInt;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendHalfOfRandomByteArrayApp {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileOutputStream fos = new FileOutputStream(args[0], true)) {
            Random random = new Random();
            while (true) {
                int count = readInt("Input count:", "Invalid count value!...");

                if (count <= 0)
                    break;

                byte[] data = new byte[count];

                random.nextBytes(data);

                for (byte val : data)
                    Console.write("%d ", val);

                Console.writeLine();

                fos.write(data, data.length / 2, data.length / 2);
            }
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
