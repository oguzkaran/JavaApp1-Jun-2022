/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var iv = Util.createIntValueByStdin();
        var a = Console.readInt("Üçüncü sayıyı giriniz:");

        Util.doWork(a, iv);
    }
}

class Util {
    public static IntValue createIntValueByStdin()
    {
        var x = Console.readInt("Birinci sayıyı giriniz:");
        var y = Console.readInt("İkinci sayıyı giriniz:");

        return new IntValue(y) {
            public int addWith(int value)
            {
                return x + value + a;
            }
        };
    }

    public static void doWork(int value, IntValue intValue)
    {
        Console.writeLine(intValue.addWith(value));
    }
}

abstract class IntValue {
    protected int a;
    public IntValue()
    {
        //...
    }

    public IntValue(int a)
    {
        this.a = a;
    }

    public abstract int addWith(int value);
    //...
}
