/*----------------------------------------------------------------------------------------------------------------------
    Apache common kütüphanesinin de Pair sınıfı vardır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.factory.NameWithIndexFactory;
import org.csystem.util.console.Console;
import org.csystem.util.tuple.Pair;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var factory = new NameWithIndexFactory();

        var names = factory.getNames(new Random(), Console.readInt("Bir sayı giriniz:"));
        var idx = Console.readInt("Aranacak indeks numarasını giriniz:");
        var name = Console.read("Aranacak ismi giriniz:");

        names.forEach(Console::writeLine);
        Console.writeLine("------------------------");

        var index = names.indexOf(Pair.of(idx, name));

        if (index != -1)
            Console.writeLine("%d, %s, %d. indekste ilk olarak görüldü", idx, name, index);
        else
            Console.writeLine("%d, %s, bulunamadı", idx, name);

        index = names.lastIndexOf(Pair.of(idx, name));

        if (index != -1)
            Console.writeLine("%d, %s, %d. indekste son olarak görüldü", idx, name, index);
        else
            Console.writeLine("%d, %s, bulunamadı", idx, name);
    }
}

