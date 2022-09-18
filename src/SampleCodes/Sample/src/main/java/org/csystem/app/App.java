/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: null değeri tutamayan CSDVectorNotNullable isimli veri collection sınıfı yazınız.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.iterable.IntRange;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Vector;

class App {
    public static void main(String[] args)
    {
        var random = new Random();
        var sVec = new Vector<String>(5, Console.readInt("Capacity artım miktarını giriniz:"));

        Console.writeLine("Capacity:%d", sVec.capacity());
        var count = Console.readInt("Bir sayı giriniz:");
        IntRange.of(0, count).forEach(i -> sVec.add(StringUtil.getRandomTextEN(random, random.nextInt(5, 15))));
        sVec.forEach(Console::writeLine);
        Console.writeLine("------------------------");
        Console.writeLine("Capacity:%d", sVec.capacity());
    }
}

