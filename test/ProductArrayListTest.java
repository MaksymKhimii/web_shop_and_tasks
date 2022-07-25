import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task1.list.ProductArrayList;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.math.BigDecimal;

public class ProductArrayListTest {
    Product product10, product11, product12, product13  = null;

    @Before
    public void beforeTest(){
       product10 = new Product("test", new BigDecimal("10"), "uk");
       product11 = new Product("test", new BigDecimal("11"), "uk");
       product12 = new Product("test", new BigDecimal("12"), "uk");
       product13 = new Product("test", new BigDecimal("13"), "uk");
    }
    @Test
    public void shouldAddToStart() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, product10);
        Product expected = product11;
        products.add(0, expected);
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldAddToEnd() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, product10);
        Product expected = product11;
        products.add(products.size(), expected);
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldAddToMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, product10);
        products.add(0,product11);
        products.add(0, product12);
        Product expected = product13;
        products.add(1, expected);
        Assert.assertEquals(expected, products.get(1));
    }

    @Test
    public void shouldAddElement() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        products.add(product11);
        products.add(product12);
        Product expected = product13;
        products.add(expected);
        Assert.assertEquals(expected, products.get(3));
        Assert.assertEquals(4, products.size());
    }

    @Test
    public void shouldRemoveFirst() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        Product expected =product11;
        products.add(expected);
        products.add(product12);
        products.remove(0);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldRemoveLast() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        Product expected =product11;
        products.add(expected);
        products.add(product12);
        products.remove(products.size() - 1);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldRemoveMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        Product expected = product11;
        products.add(expected);
        products.add(product12);
        products.remove(1);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(1));
    }

    @Test
    public void shouldReturnCorrectlyByIndex() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        products.add(product11);
        Product expected = product13;
        products.add(expected);
        Assert.assertEquals(expected, products.get(2));
    }

    @Test
    public void shouldRemoveCorrectlyByObject() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        products.add(product11);
        Product expected = product13;
        products.add(expected);
        products.remove(expected);
        Assert.assertEquals(2, products.size());
    }

    @Test
    public void shouldNotRemoveIfNotObject() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        products.add(product11);
        products.add(product13);
        products.remove(new Product("test", new BigDecimal("15"), "uk"));
        Assert.assertEquals(3, products.size());
        Assert.assertFalse(products.remove(new Product("test", new BigDecimal("15"), "uk")));
    }

    @Test
    public void shouldCorrectlyRetainCollection() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(product10);
        products.add(product11);
        products.add(product12);
        ProductArrayList<Product> retainCollection = new ProductArrayList<>();
        retainCollection.add(product12);
        retainCollection.add(new Product("test", new BigDecimal("13"), "uk"));
        products.retainAll(retainCollection);
        Assert.assertEquals(product12, products.get(0));
        Assert.assertEquals(3, products.size());
    }

}
