/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.collection.CollectionUtil;
import org.csystem.util.console.Console;
import org.csystem.util.console.commandline.CommandLineArgsUtil;
import org.csystem.util.data.test.factory.ProductFactory;
import org.csystem.util.data.test.product.ProductInfo;
import org.csystem.util.data.test.product.ProductMapper;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class App {
    public static void main(String[] args)
    {
        CommandLineArgsUtil.checkLengthEquals(args, 1, "Wrong number of arguments");

        try {
            var productFactory = ProductFactory.loadFromTextFile(Path.of(args[0]));
            var products = productFactory.PRODUCTS;
            var mapper = new ProductMapper();
            var repository = new ProductRepository(products);
            var productsInStock = repository.findProductsInStock();
            var dtos = CollectionUtil.toList(productsInStock, mapper::toProductStockDTO);

            dtos.forEach(Console::writeLine);
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