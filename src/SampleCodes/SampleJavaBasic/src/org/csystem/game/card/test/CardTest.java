package org.csystem.game.card.test;

import org.csystem.game.card.Card;

public class CardTest {
    public static void run()
    {
        Card[] deck;

        deck = Card.getShuffledDeck();

        for (Card c : deck)
            System.out.println(c.toString());
    }

    public static void main(String [] args)
    {
        run();
    }
}
