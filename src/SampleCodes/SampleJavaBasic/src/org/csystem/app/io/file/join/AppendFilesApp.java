package org.csystem.app.io.file.join;

import org.csystem.util.console.Console;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthGreater;

public class AppendFilesApp {
    private static void copyFiles(String [] args, FileOutputStream fos) throws IOException
    {
        try (fos) {
            for (int i = 0; i < args.length - 1; ++i)
                append(Path.of(args[i]), fos);
        }
    }

    private static void append(Path path, FileOutputStream fos) throws IOException
    {
        Files.copy(path, fos);
    }

    private static void restoreIfExist(String copyPath, String destPath)
    {
        if (copyPath.isEmpty())
            return;

        try {
            Path dest = Path.of(destPath);

            Files.delete(dest);
            Files.move(Path.of(copyPath), dest);
        }
        catch (IOException ex) {
            Console.writeErrLine("Alert -> File can not be deleted because of serios problem in system!...:%s", ex.getMessage());
        }
    }

    private static String copyIfExists(String pathStr) throws IOException
    {
        Path path = Path.of(pathStr);
        if (!Files.exists(path))
            return "";

        Path copyPath = Path.of(pathStr + "-bak"); //Şimdilik bu isim verildi
        Files.copy(path, copyPath);

        return copyPath.toString();
    }

    public static void run(String[] args)
    {
        checkLengthGreater(args.length, 1, "Wrong number of arguments!...");

        String copyPath = "";
        String destPath = "";

        try {
            destPath = args[args.length - 1];
            copyPath = copyIfExists(args[args.length - 1]);

            copyFiles(args, new FileOutputStream(destPath, true));
            if (!copyPath.isEmpty())
                Files.delete(Path.of(copyPath));
            Console.writeLine("Successful");
        }
        catch (SecurityException ex) {
            Console.writeErrLine("Security problem occurs:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.writeErrLine("I/O problem occurs:%s", ex.getMessage());
            restoreIfExist(copyPath, destPath);
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
