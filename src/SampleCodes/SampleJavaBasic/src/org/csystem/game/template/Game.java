package org.csystem.game.template;

public abstract class Game implements IGame {
    //...
    public final void run()
    {
        begin();

        //...

        load();
        play();

        //...

        pause();
        end();
    }
}
