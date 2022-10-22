/*----------------------------------------------------------------------------------------------------------------------
    Stream arayüzlerinin noneMatch metodu tüm elemanlar parametresi ile aldığı "predicate"'ı sağlamıyorsa true, en az biri
    sağlıyorsa false değerini üretir. noneMatch metodu etkin bir şekilde yazıldığını garanti eder
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.ProductFactory;

class App {
    public static void main(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 1, "Wrong number of arguments");

        try {
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);
            if (factoryOpt.isEmpty())
                return;

            var products = factoryOpt.get().PRODUCTS;

            if (products.stream().noneMatch(p -> p.getStock() <= 0))
                Console.writeLine("Tüm ürünler stokta mevcut");
            else
                products.stream().filter(p -> p.getStock() <= 0).forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

