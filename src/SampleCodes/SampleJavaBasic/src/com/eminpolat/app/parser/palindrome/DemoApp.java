package com.eminpolat.app.parser.palindrome;

import com.bengisuuzunyenigun.factory.parser.SourceFactory;
import com.merveartar.parser.PalindromeParser;
import org.csystem.util.console.Console;

public class DemoApp {
    public static void run()
    {
        SourceFactory factory = new SourceFactory();
        PalindromeParser parser = new PalindromeParser();

        while (true) {
            String text = Console.readString("Bir yazı giriniz:");

            if ("elma".equals(text))
                break;

            parser.setSource(factory.create(text));
            parser.parse();
            System.out.println(parser.isPalindrome() ? "Palindrome" : "Palindrome değil");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
