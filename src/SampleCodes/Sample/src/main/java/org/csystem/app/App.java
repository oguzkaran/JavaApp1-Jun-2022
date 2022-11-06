/*----------------------------------------------------------------------------------------------------------------------
    Soru: DataSourceLib 6.1.0 içerisinde bulunan StaffFactory sınıfını kullanarak çalışanları haftalık izinlerine göre
    sınıflandıran programı yazınız. staff.csv dosyasında ilgili verileri bulabilirsiniz. Örnek bir dosya için staff.csv
    dosyasından yararlanabilirsiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.StaffFactory;
import org.csystem.util.data.test.product.ProductInfo;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

class App {
    public static void main(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 1, "Wrong number of arguments");

        try {
            var factory = StaffFactory.loadFromTextFile(Path.of(args[0]));
            var staff = factory.STAFF;

            staff.forEach(Console::writeLine);

        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

class ProductRepository {
    private final List<ProductInfo> m_products;

    public ProductRepository(List<ProductInfo> products)
    {
        m_products = products;
    }

    public Iterable<ProductInfo> findProductsInStock()
    {
        return m_products.stream().filter(p -> p.getStock() > 0).collect(Collectors.toList());
    }
}