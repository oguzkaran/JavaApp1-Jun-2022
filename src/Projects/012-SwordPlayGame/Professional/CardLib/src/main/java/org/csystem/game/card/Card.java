/*----------------------------------------------------------------------
	FILE        : Card.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 02.10.2022

	Card class that represents a card for card games

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.game.card;

public class Card {

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
        return String.format("%s-%s", m_type, m_value);
    }

    public void setName(String name)
    {
        name = name.toUpperCase();
        var cardInfo = name.split("[-]");

        if (cardInfo.length != 2 || !check(cardInfo[0], cardInfo[1]))
            throw new IllegalArgumentException("Invalid card information");
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Card))
            return false;

        var card = (Card)other;

        return m_type == card.m_type && m_value == card.m_value;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
