package com.ibrahimaksu.parser.character.letter;

import org.csystem.parser.character.CharacterParser;
import org.csystem.parser.character.ICharacterSource;

public class LetterParser extends CharacterParser {
    private String m_letters;
    private String m_text;

    public LetterParser(ICharacterSource characterSource)
    {
        super(characterSource);
        m_letters = "";
        m_text = "";
    }

    public String getLetters()
    {
        return m_letters;
    }

    public String getText()
    {
        return m_text;
    }

    public void parse()
    {
        int ch;
        StringBuilder letters = new StringBuilder();
        StringBuilder text = new StringBuilder();


        while ((ch = characterSource.nextChar()) != -1) {
            text.append((char)ch);
            if (Character.isLetter(ch))
                letters.append((char) ch);
        }

        m_text = text.toString();
        m_letters = letters.toString();
    }
}
