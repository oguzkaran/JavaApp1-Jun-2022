/*----------------------------------------------------------------------------------------------------------------------
    Stack sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.data.test.factory.ProductFactory;
import org.csystem.util.data.test.product.ProductInfo;
import org.csystem.util.iterable.IntRange;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.*;

class App {
    public static void main(String[] args)
    {
        checkLengthEquals(args, 3, "Wrong number of arguments");
        try {
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);

            if (factoryOpt.isEmpty()) {
                Console.writeLine("Empty file");
                return;
            }

            var random = new Random();
            var productStack = new Stack<ProductInfo>();
            var factory = factoryOpt.get();
            var count = Integer.parseInt(args[1]);
            IntRange.of(0, count).forEach(i -> productStack.push(factory.getRandomProduct(random).orElse(null)));

            var id = Integer.parseInt(args[2]);
            var index = productStack.search(new ProductInfo().setId(id));

            if (index != -1) {
                var pi = productStack.get(productStack.size() - index);

                Console.writeLine("--------------------------------------------------------------");
                Console.writeLine("%d, %s", index, pi);
            }
            else
                Console.writeLine("Not found");

            int i = 0;

            while (!productStack.empty())
                Console.writeLine("%d, %s", ++i, productStack.pop());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values");
        }
    }
}


