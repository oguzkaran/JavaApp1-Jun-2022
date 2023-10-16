package com.mesutgunduz.parser.numeric;

import org.csystem.parser.character.ICharacterSource;
import org.csystem.parser.character.ICharacterSourceParser;
import org.csystem.util.console.Console;

public class FirstIntParser implements ICharacterSourceParser {
    private int m_value;

    public int getValue()
    {
        return m_value;
    }

    public void parse(ICharacterSource source)
    {
        int ch;
        StringBuilder sb = new StringBuilder();

        while ((ch = source.nextChar()) != -1) {
            if (!Character.isDigit(ch))
                break;

            sb.append((char) ch);
        }

        m_value = Integer.parseInt(sb.toString());
    }
}
