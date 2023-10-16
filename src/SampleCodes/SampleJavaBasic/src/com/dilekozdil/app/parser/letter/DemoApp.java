package com.dilekozdil.app.parser.letter;

import com.bengisuuzunyenigun.factory.parser.SourceFactory;
import com.ibrahimaksu.parser.character.letter.LetterParser;
import org.csystem.util.thread.ThreadUtil;

public class DemoApp {
    public static void run()
    {
        SourceFactory factory = new SourceFactory();

        while (true) {
            LetterParser parser = new LetterParser(factory.create());

            System.out.println("------------------------------------------------");
            parser.parse();
            System.out.printf("Text:%s%n", parser.getText());
            System.out.printf("Letters:%s%n", parser.getLetters());
            System.out.println("------------------------------------------------");
            ThreadUtil.sleep(1000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
