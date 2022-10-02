package org.csystem.game.card;

import java.util.Optional;

public enum CardValue {
    TWO("İki"), THREE("Üç"), FOUR("Dört"), FIVE("Beş"), SIX("Altı"), SEVEN("Yedi"), EIGHT("Sekiz"), NINE("Dokuz"),
    TEN("On"), KNAVE("Vale"), QUEEN("Kiz"), KING("Papaz"), ACE("As");

    public final String str;

    CardValue(String str)
    {
        this.str = str;
    }

    public static Optional<CardValue> getCardValueByStr(String str)
    {
        for (var value : values())
            if (value.str.equals(str))
                return Optional.of(value);

        return Optional.empty();
    }

    //...
}