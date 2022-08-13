/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte anonim sınıf kullanılarak adeta nesneye ilk değer verme (initialization) biçiminde kod yazılmıştır.
    Bu sentaks nesneye ilk değer verme sentaksı değildir. Anonim sınıf içerisinde non-static initializer yazmak demektir.
    Dikkat edilirse p referansının dinamik türü Product deği, Product sınıfından türetilmiş olanm bir anonim sınıf
    türündendir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.shopping.Product;
import org.csystem.util.console.Console;

import java.math.BigDecimal;

class App {
    public static void main(String[] args)
    {
        Product p = new Product() {{setName("laptop"); setStock(100); setCost(BigDecimal.valueOf(7000)); setUnitPrice(BigDecimal.valueOf(10000)); setExpiryDate(null);}};

        Console.writeLine(p.getClass().getName());

        Console.writeLine(p.getName());
    }
}

