/*----------------------------------------------------------------------
	FILE        : CardValue.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 02.10.2022

	CardValue enum class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.game.card;

import java.util.Optional;

public enum CardValue {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KNAVE, QUEEN, KING, ACE;
    public static Optional<CardValue> getCardValueByStr(String str)
    {
        for (var value : values())
            if (value.toString().equals(str))
                return Optional.of(value);

        return Optional.empty();
    }

    //...
}