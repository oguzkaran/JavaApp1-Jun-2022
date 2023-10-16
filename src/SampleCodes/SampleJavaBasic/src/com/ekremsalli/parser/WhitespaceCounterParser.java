package com.ekremsalli.parser;

import org.csystem.parser.character.ICharacterSource;
import org.csystem.parser.character.ICharacterSourceParser;

public class WhitespaceCounterParser implements ICharacterSourceParser {
    private int m_count;

    public int getCount()
    {
        return m_count;
    }

    public void parse(ICharacterSource characterSource)
    {
        int ch;

        while ((ch = characterSource.nextChar()) != -1)
            if (Character.isWhitespace(ch))
                ++m_count;
    }
}
