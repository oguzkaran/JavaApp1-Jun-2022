package org.csystem.app.string.concatwithdelimiter;

import org.csystem.util.string.ConcatStrings;

import java.util.Scanner;

public class ConcatWithDelimiterApp {
    private static void doConCat(ConcatStrings concatStrings, Scanner kb)
    {
        System.out.print("Ayracı giriniz:");
        String delimiter = kb.nextLine();

        String s = concatStrings.concat(delimiter);

        System.out.println(s);
    }

    public static void fill(ConcatStrings concatStrings, Scanner kb)
    {
        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String s = kb.nextLine();

            if ("elma".equals(s))
                break;

            concatStrings.add(s);
        }
    }

    private static void run()
    {
        Scanner kb = new Scanner(System.in);
        ConcatStrings concatStrings = new ConcatStrings();

        fill(concatStrings, kb);
        doConCat(concatStrings, kb);
    }

    public static void main(String[] args)
    {
        run();
    }
}
