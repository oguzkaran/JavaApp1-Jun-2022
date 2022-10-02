/*----------------------------------------------------------------------
	FILE        : CardType.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 02.10.2022

	CardType enum class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.game.card;

import java.util.Optional;

public enum CardType {
    SPADE, CLUB, DIAMOND, HEART;
    public static Optional<CardType> getCardTypeByStr(String str)
    {
        for (var type : values())
            if (type.toString().equals(str))
                return Optional.of(type);

        return Optional.empty();
    }
}