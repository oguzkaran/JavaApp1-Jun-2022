package org.csystem.util.thread;

public class ThreadUtil {
    public static void sleep(long millisecond)
    {
        try {
            Thread.sleep(millisecond);
        }
        catch (InterruptedException ignore) {

        }
    }
}
