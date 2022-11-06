/*----------------------------------------------------------------------------------------------------------------------
    Stream arayüzlerinin dropWhile metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Random;
import java.util.stream.IntStream;

class App {
    public static void main(String[] args)
    {
        var in = new KeyBoardInput();
        var out = new FileOutput();

        Util.copy(in, out);

    }
}


class NormalDoor implements IDoor {
    @Override
    public void open()
    {
        //...
    }

    @Override
    public void close()
    {
        //...
    }
}

class TimedDoor implements IDoor, ITimer {
    //...
    @Override
    public void open()
    {
        //...
    }

    @Override
    public void close()
    {
        //...
    }

    @Override
    public void timeout(long duration)
    {
        //...
    }
}

interface ITimer {
    void timeout(long duration);
}

interface IDoor {
    void open();
    void close();
}

interface IInput {
    //...
    int read(byte [] data);
    //
}

interface IOutput {
    //...
    void write(byte [] data);
    //
}

class KeyBoardInput implements IInput {
    @Override
    public int read(byte[] data)
    {
        return 0;
    }
}

class FileOutput implements IOutput {
    //...


    @Override
    public void write(byte[] data)
    {

    }
}

class Util {
    public static void copy(IInput in, IOutput out)
    {
        //...
    }
}
