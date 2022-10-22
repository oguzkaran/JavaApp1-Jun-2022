/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.ProductFactory;
import org.csystem.util.data.test.product.ProductInfo;

class App {
    public static void main(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 1, "Wrong number of arguments");

        try {
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);
            if (factoryOpt.isEmpty())
                return;

            var products = factoryOpt.get().PRODUCTS;

            var result = products.stream()
                    .filter(p -> p.getStock() <= 0)
                    .map(ProductInfo::getName)
                    .reduce((r, n) -> r + ":" + n );

            result.ifPresentOrElse(r -> Console.writeLine("%s", r), () -> Console.writeLine("No product in stock"));
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

