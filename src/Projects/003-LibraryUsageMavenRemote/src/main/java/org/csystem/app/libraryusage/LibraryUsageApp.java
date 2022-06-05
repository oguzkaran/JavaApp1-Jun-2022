package org.csystem.app.libraryusage;

import org.csystem.util.console.Console;
import org.csystem.util.random.RandomUtil;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class LibraryUsageApp {
    public static void run()
    {
        int count = Console.readInt("Kaç tane şifre üreteceksiniz?", "Hatalı giriş yaptınız!...");
        int n = Console.readInt("Her şifre kaç karakterden oluşsun?", "Hatalı giriş yaptınız!...");
        Random r = new Random();

        for (int i = 0; i < count; ++i)
            Console.writeLine("%d. şifre: %s", i + 1, StringUtil.getRandomTextTR(r, n));

        for (int i = 0; i < 10; ++i)
            Console.write("%d ", RandomUtil.nextInt(r, 0, 100));

        Console.writeLine();
    }
}
