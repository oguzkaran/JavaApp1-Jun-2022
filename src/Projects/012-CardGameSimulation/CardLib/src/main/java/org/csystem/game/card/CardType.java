package org.csystem.game.card;

import java.util.Optional;

public enum CardType {
    SPADE("Maça"), CLUB("Sinek"), DIAMOND("Karo"), HEART("Kupa");

    public final String str;
    CardType(String str)
    {
        this.str = str;
    }

    public static Optional<CardType> getCardTypeByStr(String str)
    {
        for (var type : values())
            if (type.str.equals(str))
                return Optional.of(type);

        return Optional.empty();
    }

    //...
}