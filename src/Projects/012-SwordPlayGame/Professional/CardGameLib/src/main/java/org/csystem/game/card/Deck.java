/*----------------------------------------------------------------------
	FILE        : Deck.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 08.10.2022

	Deck class that represents a deck for card games

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.game.card;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Deck implements Iterable<Card> {
    private static final int SHUFFLE_COUNT = 1000;
    private final Card [] m_cards;

    private static Deck getNewDeck()
    {
        var cards = new Card[52];
        var index = 0;

        for (var type : CardType.values())
            for (var value : CardValue.values())
                cards[index++] = new Card(type, value);

        return new Deck(cards);
    }

    private static Deck getShuffledDeck(int count)
    {
        var deck = getNewDeck();

        shuffleDeck(deck, count);

        return deck;
    }

    private static void shuffleDeck(Deck deck, int count)
    {
        var random = new Random();

        for (int i = 0; i < count; ++i)
            swap(deck.m_cards, random.nextInt(deck.m_cards.length), random.nextInt(deck.m_cards.length));
    }

    private static void swap(Card [] cards, int i, int k)
    {
        Card temp = cards[i];

        cards[i] = cards[k];
        cards[k] = temp;
    }

    private Deck(Card [] cards)
    {
        m_cards = cards;
    }

    public static Deck of()
    {
        return getNewDeck();
    }

    public static Deck ofShuffled(int count)
    {
        return getShuffledDeck(count);
    }

    public static Deck ofShuffled()
    {
        return ofShuffled(SHUFFLE_COUNT);
    }

    public void shuffle()
    {
        shuffle(SHUFFLE_COUNT);
    }

    public void shuffle(int count)
    {
        shuffleDeck(this, count);
    }

    public void setCard(int index,  CardType type, CardValue value)
    {
        m_cards[index] = new Card(type, value);
    }

    public Card getCard(int index) {return m_cards[index];}

    public int cardCount() {return m_cards.length;}

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Deck))
            return false;

        return Arrays.equals(m_cards, ((Deck)other).m_cards);
    }

    @Override
    public String toString()
    {
        var sb = new StringBuilder("[");

        for (var c : m_cards)
            sb.append(c).append(", ");

        return sb.delete(sb.length() - 2, sb.length()) .append("]").toString();
    }

    @Override
    public Iterator<Card> iterator()
    {
        return new Iterator<>() {
            int index = -1;
            @Override
            public boolean hasNext()
            {
                return index + 1 < m_cards.length;
            }

            @Override
            public Card next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such card");

                return m_cards[++index];
            }
        };
    }
}
