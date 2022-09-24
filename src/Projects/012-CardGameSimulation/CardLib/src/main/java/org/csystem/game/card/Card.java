package org.csystem.game.card;

public class Card {
    private CardValue m_value;
    private CardType m_type;

    public static Card[] getShuffledDeck()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public Card(CardValue value, CardType type)
    {
        m_value = value;
        m_type = type;
    }

    public Card(String name)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public String getName()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public void setName(String name)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("TODO");
    }
}
