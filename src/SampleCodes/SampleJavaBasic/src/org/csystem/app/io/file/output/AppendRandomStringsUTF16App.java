package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConverter;
import org.csystem.util.string.StringUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.csystem.util.console.Console.readInt;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomStringsUTF16App {
    private static void writeString(String str, FileOutputStream fos) throws IOException
    {
        byte [] data = BitConverter.getBytes(str, StandardCharsets.UTF_16);
        byte [] dataLength = BitConverter.getBytes(data.length);

        fos.write(dataLength);
        fos.write(data);
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileOutputStream fos = new FileOutputStream(args[0], true)) {
            Random random = new Random();
            int count = readInt("Input count:", "Invalid count value!...");

            while (count-- > 0) {
                String str = StringUtil.getRandomTextTR(random, random.nextInt(5, 10));

                Console.writeLine("%s", str);
                writeString(str, fos);
            }

            Console.writeLine();
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
