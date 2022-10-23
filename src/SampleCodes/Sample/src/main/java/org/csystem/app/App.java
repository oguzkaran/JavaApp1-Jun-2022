/*----------------------------------------------------------------------------------------------------------------------
    Soru: stdin'den alınan count kadar rasgele ürün elde eden kodu yazınız.
    Örnekte hiç ürün olmamsı duruöu da dolaylı olarak kontrol edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.ProductFactory;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

class App {
    public static void main(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 1, "Wrong number of arguments");

        try {
            var factory = ProductFactory.loadFromTextFile(Path.of(args[0]));

            var random = new Random();
            var count = Console.readInt("Input count:");

            Stream.generate(() -> factory.getRandomProduct(random))
                            .limit(count)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

