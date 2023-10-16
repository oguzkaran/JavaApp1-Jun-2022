package com.cemilaksel.app.parser.firstint;

import com.bengisuuzunyenigun.factory.parser.SourceFactory;
import com.mesutgunduz.parser.numeric.FirstIntParser;
import org.csystem.util.console.Console;

public class DemoApp {
    public static void run()
    {
        SourceFactory factory = new SourceFactory();
        FirstIntParser parser = new FirstIntParser();

        while (true) {
            try {
                String text = Console.readString("Bir yazı giriniz:");

                if ("elma".equals(text))
                    break;

                parser.parse(factory.create(text));
                Console.writeLine("Elde edilen sayı:%d", parser.getValue());
            }
            catch (NumberFormatException ignore) {
                Console.writeLine("Yazıdan bir sayı elde edilemedi!...");
            }
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
