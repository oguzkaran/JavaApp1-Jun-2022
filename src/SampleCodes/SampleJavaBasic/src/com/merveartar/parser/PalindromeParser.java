package com.merveartar.parser;

import org.csystem.parser.character.CharacterParser;
import org.csystem.parser.character.ICharacterSource;
import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

public class PalindromeParser extends CharacterParser {
    private boolean m_palindrome;
    private String m_text;

    private boolean m_parsed;

    public PalindromeParser()
    {
        this(null);
    }

    public PalindromeParser(ICharacterSource source)
    {
        super(source);
        m_text = "";
    }

    public void setSource(ICharacterSource source)
    {
        characterSource = source;
    }

    public boolean isPalindrome()
    {
        return m_palindrome;
    }

    public String getText()
    {
        return m_text;
    }

    public boolean isParsed()
    {
        return m_parsed;
    }

    public void parse()
    {
        StringBuilder sb = new StringBuilder();
        int ch;

        while ((ch = characterSource.nextChar()) != -1)
            sb.append((char)ch);

        m_parsed = true;
        m_text = sb.toString();
        m_palindrome = StringUtil.isPalindrome(m_text);
    }
}
