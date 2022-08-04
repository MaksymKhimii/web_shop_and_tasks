import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task1.list.ProductArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.math.BigDecimal;

public class ProductArrayListTest {

    Product product10, product11, product12, product13 = null;

    @Before
    public void beforeTest() {
        product10 = new Product("test", new BigDecimal("10"), "uk");
        product11 = new Product("test", new BigDecimal("11"), "uk");
        product12 = new Product("test", new BigDecimal("12"), "uk");
        product13 = new Product("test", new BigDecimal("13"), "uk");
    }

    @Test
    public void shouldAddToStart() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(0, product10);
        products.add(0, product11);

        Assert.assertEquals(product11, products.get(0));
    }

    @Test
    public void shouldAddToEnd() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(0, product10);
        products.add(products.size(), product11);

        Assert.assertEquals(product11, products.get(products.size() - 1));
    }

    @Test
    public void shouldAddToMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(0, product10);
        products.add(0, product11);
        products.add(0, product12);
        products.add(1, product13);

        Assert.assertEquals(product13, products.get(1));
    }

    @Test
    public void shouldAddElement() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.add(product12);
        products.add(product13);

        Assert.assertEquals(product13, products.get(3));
        Assert.assertEquals(4, products.size());
    }

    @Test
    public void shouldRemoveFirst() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.add(product12);
        products.remove(0);

        Assert.assertEquals(2, products.size());
        Assert.assertEquals(product11, products.get(0));
    }

    @Test
    public void shouldRemoveLast() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.add(product12);
        products.remove(products.size() - 1);

        Assert.assertEquals(2, products.size());
        Assert.assertEquals(product11, products.get(products.size() - 1));
    }

    @Test
    public void shouldRemoveMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product12);
        products.add(product12);
        products.remove(1);

        Assert.assertEquals(2, products.size());
        Assert.assertEquals(product12, products.get(1));
    }

    @Test
    public void shouldReturnCorrectlyByIndex() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.add(product13);

        Assert.assertEquals(product13, products.get(2));
    }

    @Test
    public void shouldRemoveCorrectlyByObject() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.add(product13);
        products.remove(product13);

        Assert.assertEquals(2, products.size());
    }

    @Test
    public void shouldNotRemoveIfNotObject() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.add(product12);
        products.add(product13);
        products.remove(product13);

        Assert.assertEquals(3, products.size());
        Assert.assertTrue(products.remove(product12));
    }

    @Test
    public void shouldCorrectlyRetainCollection() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(product10);
        products.add(product12);
        ProductArrayList<Product> retainCollection = new ProductArrayList<>();
        retainCollection.add(product12);
        products.retainAll(retainCollection);

        Assert.assertEquals(product12, products.get(0));
        Assert.assertEquals(1, products.size());
    }
}
