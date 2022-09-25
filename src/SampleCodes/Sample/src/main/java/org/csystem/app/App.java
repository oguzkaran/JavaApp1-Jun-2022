/*----------------------------------------------------------------------------------------------------------------------
    LinkedList sınıfının addFirst ve pollFirst metotları:
    poll, pollFirst ve pollLast metotları liste boş ise null değerine geri dönerler. Bu durumda algoritmamızda eğer linked
    list içerisinde null değer tutulmadığı garanti altındaysa bu metotların geri dönüş değerinden listenin boş olup olmadığı
    anlaşılabilir. Ancak listede null da değer olarak tutuluyorsa ve o an çağrılmada o değer de verilecekse geri dönüş
    değeri listenin boş olup olmadığı hakkında bilgi vermez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.data.test.factory.ProductFactory;
import org.csystem.util.data.test.product.ProductInfo;
import org.csystem.util.iterable.IntRange;

import java.io.IOException;
import java.util.LinkedList;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class App {
    public static void main(String[] args)
    {
        checkLengthEquals(args, 2, "Wrong number of arguments");
        try {
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);

            if (factoryOpt.isEmpty()) {
                Console.writeLine("Empty file");
                return;
            }

            var productLList = new LinkedList<ProductInfo>();
            var factory = factoryOpt.get();
            var count = Integer.parseInt(args[1]);
            IntRange.of(0, count).forEach(i -> productLList.addFirst(factory.PRODUCTS.get(i)));

            while (!productLList.isEmpty())
                Console.writeLine(productLList.pollFirst());

            Console.writeLine();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values");
        }
    }
}
