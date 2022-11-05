/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte "unmodifiable" bir liste elde edildiğinden add işlemi exception fırlatılmasına yol açar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.ProductFactory;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

class App {
    public static void main(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 1, "Wrong number of arguments");

        try {
            var factory = ProductFactory.loadFromTextFile(Path.of(args[0]));
            var products = factory.PRODUCTS;
            var count = Console.readInt("Bir sayı giriniz:");

            products.stream().sorted().forEach(Console::writeLine);
            Console.writeLine("-------------------------------------------");
            var result = products.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(count).toList();

            result.forEach(Console::writeLine);

            result.add(factory.getRandomProduct(new Random()).orElse(null));
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
