package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadStringsApp {
    public static boolean readString(FileInputStream fis) throws IOException
    {
        int result;
        byte [] dataLength = new byte[Integer.BYTES];

        result = fis.read(dataLength);

        if (result == -1)
            return false;

        if (result != dataLength.length)
            throw new IOException("Invalid file format!...");

        byte [] data = new byte[BitConverter.toInt(dataLength)];

        result = fis.read(data);

        if (result != data.length)
            throw new IOException("Invalid file format!...");

        Console.writeLine(BitConverter.toString(data, StandardCharsets.UTF_8));

        return true;
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            while (readString(fis))
                ;
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
