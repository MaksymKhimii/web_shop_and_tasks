import com.epam.khimii.task1.Entity.Product;
import com.epam.khimii.task1.List.ProductArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

public class ProductConditionalIteratorTest {
    @Test
    public void shouldCorrectlyWorkIteratorWithTrue() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        ProductArrayList<Product> newProducts = new ProductArrayList<>();
        Iterator<Product> it=products.conditionIterator((c)->true);
        while(it.hasNext()){
            newProducts.add(it.next());
        }
        Assert.assertArrayEquals(products.toArray(), newProducts.toArray());
    }

    @Test
    public void shouldCorrectlyWorkIteratorWithPredicate() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        ProductArrayList<Product> newProducts = new ProductArrayList<>();
        Iterator<Product> it=products.conditionIterator((c)->c.getPrice().compareTo(new BigDecimal("12"))<0);
        while(it.hasNext()){
            newProducts.add(it.next());
        }
        ProductArrayList<Product> expected = new ProductArrayList<>();
        expected.add(new Product("test", new BigDecimal("10"), "uk"));
        expected.add(new Product("test", new BigDecimal("11"), "uk"));
        Assert.assertArrayEquals(expected.toArray(), newProducts.toArray());
        Assert.assertEquals(2, newProducts.size());
    }
}
