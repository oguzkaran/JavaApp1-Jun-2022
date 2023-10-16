package org.csystem.app.game.combat.enemy;

import org.csystem.app.game.combat.color.Color;

public class Enemy {
    private String m_name;
    private Color m_color;
    //...

    public String getName()
    {
        return m_name;
    }

    public Enemy setName(String name)
    {
        m_name = name;

        return this;
    }

    public Color getColor()
    {
        return m_color;
    }

    public Enemy setColor(Color color)
    {
        m_color = color;

        return this;
    }

    public String toString()
    {
        return String.format("Name:%s, Color:%s", m_name, m_color);
    }
}
