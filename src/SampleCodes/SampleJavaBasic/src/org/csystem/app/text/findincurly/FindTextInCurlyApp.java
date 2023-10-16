package org.csystem.app.text.findincurly;

import java.util.Scanner;

public class FindTextInCurlyApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String s = kb.nextLine();

            if ("elma".equals(s))
                break;

            FindTextInCurly findTextInCurly = new FindTextInCurly(s);

            findTextInCurly.parse();

            System.out.println(findTextInCurly.isValid() ? findTextInCurly.getResult() : "yanlış bir giriş");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
