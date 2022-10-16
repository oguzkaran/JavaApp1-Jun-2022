/*----------------------------------------------------------------------------------------------------------------------

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

            var stock = Console.readInt("Stok miktarını giriniz:");
            var products = factoryOpt.get().PRODUCTS;

            products.stream()
                    .filter(p -> p.getStock() < stock)
                    .filter(p -> p.getName().contains("Cat"))
                    .forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

