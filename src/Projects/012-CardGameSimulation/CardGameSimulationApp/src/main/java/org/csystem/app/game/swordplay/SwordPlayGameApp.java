package org.csystem.app.game.swordplay;

import org.csystem.game.card.Card;
import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.scheduler.Scheduler;

import java.awt.event.ContainerAdapter;

public class SwordPlayGameApp {
    public static Card selectCard()
    {
        for (;;) {
            try {
                return new Card(Console.read("Lütfen bir kart seçiniz: Kupa-Papaz"));
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

    private static void playGame(int winScore)
    {
        var count = 0;
        var playerScore = 0;

        for (;;) {
            var game = new SwordPlayGame(Card.getShuffledDeck(), selectCard());

            game.playGame(Console::writeLine);
            Console.writeLine(game.isPlayerWin() ? "Bu oyunu siz kazandınız!..." : "Bu oyunu kaybettiniz!...");
            ++count;

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
