package org.csystem.app.game.swordplay;

import org.csystem.game.card.Card;
import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;

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


    private static void playGame(int winScore)
    {
        var playerScore = 0;
        var computerScore = 0;

        for (;;) {
            var card = selectCard();

            if (playerScore >= winScore) {
                Console.writeLine("Tebrikler oyunu kazandınız");
                break;
            }
            if (computerScore >= winScore) {
                Console.writeLine("Maalesef oyunu kaybettiniz");
                break;
            }
        }
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
