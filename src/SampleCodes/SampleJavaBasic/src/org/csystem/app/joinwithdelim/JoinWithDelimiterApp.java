package org.csystem.app.joinwithdelim;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Scanner;

public class JoinWithDelimiterApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        String  [] texts = new String[n];

        for (int i = 0; i < n; ++i)
            StringUtil.fillRandomTextsTR(r, texts, r.nextInt(5, 11));

        ArrayUtil.print(texts);

        System.out.printf("Text:%s%n", StringUtil.join(texts, '-'));
    }
}
