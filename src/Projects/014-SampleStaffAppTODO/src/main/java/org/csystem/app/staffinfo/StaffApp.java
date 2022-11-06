package org.csystem.app.staffinfo;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.StaffFactory;

import java.nio.file.Path;
import java.time.DayOfWeek;

public class StaffApp {
    public static void run(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 2, "Wrong number of arguments");

        try {
            var restDay =DayOfWeek.valueOf(args[1].toUpperCase());
            var factory = StaffFactory.loadFromTextFile(Path.of(args[0]));
            var staff = factory.STAFF;

            staff.forEach(Console::writeLine);
            //TODO:
        }
        catch (IllegalArgumentException ignore) {
            Console.Error.writeLine("Invalid day text!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine(ex.getMessage());
        }
    }
}
