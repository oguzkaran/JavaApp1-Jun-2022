package org.csystem.app.birthdateremainder;

import org.csystem.util.console.Console;
import org.csystem.util.datetime.BirthDateInfo;

public class BirtDateRemainderApp {
    private static BirthDateInfo createBirthDateInfoByArguments(String [] args)
    {
        //...
        var day = Integer.parseInt(args[0]);
        var month = Integer.parseInt(args[1]);
        var year = Integer.parseInt(args[2]);

        return new BirthDateInfo(day, month, year);
    }

    public static void run(String [] args)
    {
        String [] messages = {"Doğum gününüz kutlu olsun",  "Geçmiş doğum gününüz kutlu olsun", "Doğum gününüzü şimdiden kutlarız"};
        var bi = createBirthDateInfoByArguments(args);

        Console.writeLine(messages[bi.getBirthDateStatus().ordinal()]);
        Console.writeLine("Yaşınız:%f", bi.getAge());
    }
}
