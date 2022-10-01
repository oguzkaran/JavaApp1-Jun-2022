package org.csystem.game.card;

import java.util.Random;

public class Card {
    private static final int SHUFFLE_COUNT = 1000;
    private CardValue m_value;
    private CardType m_type;

    private boolean check(String typeStr, String valueStr)
    {
        var optType = CardType.getCardTypeByStr(typeStr);
        var optValue = CardValue.getCardValueByStr(valueStr);

        if (optType.isEmpty() || optValue.isEmpty())
            return false;

        m_type = optType.get();
        m_value = optValue.get();

        return true;
    }

    public static Card [] getNewDeck()
    {
        var deck = new Card[52];
        var index = 0;

        for (var type : CardType.values())
            for (var value : CardValue.values())
                deck[index++] = new Card(type, value);

        return deck;
    }

    public static Card[] getShuffledDeck()
    {
        var deck = getNewDeck();

        shuffleDeck(deck, SHUFFLE_COUNT);

        return deck;
    }

    public static void shuffleDeck(Card[] deck, int count)
    {
        var random = new Random();

        for (int i = 0; i < count; ++i)
            swap(deck, random.nextInt(deck.length), random.nextInt(deck.length));
    }

    public static void swap(Card [] deck, int i, int k)
    {
        Card temp = deck[i];

        deck[i] = deck[k];
        deck[k] = temp;
    }

    public Card(CardType type, CardValue value)
    {
        m_type = type;
        m_value = value;
    }

    public Card(String name)
    {
        setName(name);
    }

    public String getName()
    {
        return String.format("%s-%s", m_type.str, m_value.str);
    }

    public void setName(String name)
    {
        var cardInfo = name.split("[-]");

        if (cardInfo.length != 2 || !check(cardInfo[0], cardInfo[1]))
            throw new IllegalArgumentException("Invalid card information");
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
