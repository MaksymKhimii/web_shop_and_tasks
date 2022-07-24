import com.epam.khimii.task1.Entity.Product;
import com.epam.khimii.task1.List.ProductArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductIteratorTest {
    @Test
    public void shouldCorrectlyWorkIteratorInForEach() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        ProductArrayList<Product> newProducts = new ProductArrayList<>();
        for (Product temp : products) {
            newProducts.add(temp);
        }
        Assert.assertArrayEquals(products.toArray(), newProducts.toArray());
    }
}
