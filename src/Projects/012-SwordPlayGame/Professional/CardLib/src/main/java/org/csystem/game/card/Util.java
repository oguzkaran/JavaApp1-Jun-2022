package org.csystem.game.card;

class Util {
    public static void sleep(long ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignore) {

        }
    }
}
