package org.csystem.parser.character;

import org.csystem.parser.IParser;

public abstract class CharacterParser implements IParser {
    protected ICharacterSource characterSource;

    protected CharacterParser(ICharacterSource characterSource)
    {
        this.characterSource = characterSource;
    }
}
