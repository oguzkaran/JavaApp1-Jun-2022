package com.bengisuuzunyenigun.factory.parser;

import com.alierdemgungor.source.CharArraySource;
import com.ekremsalli.parser.source.StringSource;
import org.csystem.parser.character.ICharacterSource;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class SourceFactory {
    private final Random m_random = new Random();

    public ICharacterSource create(String str)
    {
        return switch (m_random.nextInt(2)) {
            case 0 -> new StringSource(str);
            //...
            default -> new CharArraySource(str);
        };
    }

    public ICharacterSource create()
    {
        return create(StringUtil.getRandomText(m_random, m_random.nextInt(5, 16), "0123456789abcdefAbCDEF:?_-/\\"));
    }
}
