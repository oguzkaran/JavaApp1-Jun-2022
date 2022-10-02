package org.csystem.app.game.swordplay;

import org.csystem.game.card.Card;
import org.csystem.game.card.Deck;
import org.csystem.game.card.SwordPlayGame;
import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.scheduler.Scheduler;

import java.awt.event.ContainerAdapter;

public class SwordPlayGameApp {
    public static Card selectCard()
    {
        for (;;) {
            try {
                return new Card(Console.read("Lütfen biçiminde bir kart seçiniz:"));
            }
            catch (IllegalArgumentException ignore) {
                Console.writeLine("Geçersiz kart seçtiniz!...");
            }
        }
    }

    private static void printReport(int playerScore, int computerScore, int winScore)
    {
        if (playerScore >= winScore)
            Console.writeLine("Kazandınız!...");
        else
            Console.writeLine("Kaybettiniz!...");
    }

    private static void playGameCallback(Card card, boolean win)
    {
        Console.writeLine("%s -> %s", card, win ? "Oyuncu" : "Bilgisayar");
    }

    private static void resultCallback(boolean win)
    {
        Console.writeLine(win ? "Bu oyunu siz kazandınız!..." : "Bu oyunu kaybettiniz!...");
    }

    private static void playGame(int winScore)
    {
        var count = 0;
        var playerScore = 0;

        for (;;) {
            var game = new SwordPlayGame(Deck.ofShuffled(), selectCard());

            game.playGame(SwordPlayGameApp::playGameCallback, SwordPlayGameApp::resultCallback);
            ++count;
            if (game.isPlayerWin())
                ++playerScore;

            if (playerScore >= winScore || count - playerScore >= winScore)
                break;
        }

        printReport(playerScore, count - playerScore, winScore);
    }

    public static void run(String [] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args.length, 1, "Geçersiz argüman sayısı");

        try {
            playGame(Integer.parseInt(args[0]));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Geçersiz toplam puan değeri");
        }
    }
}
