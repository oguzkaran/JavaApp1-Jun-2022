package com.ekremsalli.parser.source;

import org.csystem.parser.character.ICharacterSource;

public class StringSource implements ICharacterSource {
    private final String m_text;
    private int m_index;

    public StringSource(String text)
    {
        m_text = text;
    }

    public int nextChar()
    {
        return m_index == m_text.length() ? -1 : m_text.charAt(m_index++);
    }
}
