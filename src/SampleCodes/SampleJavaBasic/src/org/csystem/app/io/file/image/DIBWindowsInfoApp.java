package org.csystem.app.io.file.image;

import org.csystem.util.console.Console;
import org.csystem.util.image.bitmap.DIBWindows;

import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class DIBWindowsInfoApp {
    private static void printImageInfo(DIBWindows dibWindows) throws IOException
    {
        Console.writeLine("Identity:%s", dibWindows.getIdentityStr());
        Console.writeLine("Size in bytes:%d", dibWindows.getSizeIntBytes());
        Console.writeLine("Pixels Start Offset:%d", dibWindows.getPixelsStartOffset());
        Console.writeLine("Width * Height = %d * %d", dibWindows.getWidth(), dibWindows.getHeight());
        Console.writeLine("Horizontal Resolution:%d", dibWindows.getHorizontalResolution());
        Console.writeLine("Vertical Resolution:%d", dibWindows.getVerticalResolution());
    }
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (DIBWindows dibWindows = new DIBWindows(args[0])) {
            printImageInfo(dibWindows);
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
