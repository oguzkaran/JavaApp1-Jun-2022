package com.cemilaksel.game.race.car.nascar;

import org.csystem.game.template.IGame;

public class NascarGame implements IGame {
    //...
    public void begin()
    {
        System.out.println("NasCarGame start");
    }

    public void play()
    {
        System.out.println("NasCarGame play");
    }

    public void load()
    {
        System.out.println("NasCarGame load");
    }

    public void pause()
    {
        System.out.println("NasCarGame pause");
    }

    public void end()
    {
        System.out.println("NasCarGame end");
    }

    //...
}
