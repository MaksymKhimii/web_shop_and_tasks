import com.epam.khimii.task1.Entity.Product;
import com.epam.khimii.task1.List.ProductArrayList;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.math.BigDecimal;

public class ProductArrayListTest {

    /**
     * the creation of an ArrayList and the
     * first adding new Product was taken out of tests
     * @return ProductArrayList<Product with one Prod
     */
    @Before
    public ProductArrayList<Product> onceExecutedBeforeAll() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        return products;
    }

   @Test
    public void shouldAddToStart() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(0, expected);
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldAddToEnd() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(products.size(), expected);
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldAddToMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, new Product("test", new BigDecimal("11"), "uk"));
        products.add(0, new Product("test", new BigDecimal("12"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(1, expected);
        Assert.assertEquals(expected, products.get(1));
    }


    @Test
    public void shouldAddElement() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        Assert.assertEquals(expected, products.get(3));
        Assert.assertEquals(4, products.size());
    }

   @Test
    public void shouldRemoveFirst() {
       ProductArrayList<Product> products =  onceExecutedBeforeAll();
        Product expected = new Product("test2", new BigDecimal("11"), "uk");
        products.add(expected);
        products.add(new Product("test3", new BigDecimal("12"), "uk"));
        products.remove(0);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldRemoveLast() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(expected);
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        products.remove(products.size() - 1);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldRemoveMiddle() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(expected);
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        products.remove(1);
        Assert.assertEquals(2, products.size());
        Assert.assertNotEquals(expected, products.get(1));
    }

    @Test
    public void shouldReturnCorrectlyByIndex() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        Assert.assertEquals(expected, products.get(2));
    }

    @Test
    public void shouldRemoveCorrectlyByObject() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        products.remove(expected);
        Assert.assertEquals(2, products.size());
    }

    @Test
    public void shouldNotRemoveIfNotObject() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        products.add(new Product("test2", new BigDecimal("11"), "uk"));
        products.add(new Product("test3", new BigDecimal("13"), "uk"));
        products.remove(new Product("test", new BigDecimal("15"), "uk"));
        Assert.assertEquals(3, products.size());
        Assert.assertFalse(products.remove(new Product("test", new BigDecimal("15"), "uk")));
    }

    @Test
    public void shouldCorrectlyRetainCollection() {
        ProductArrayList<Product> products =  onceExecutedBeforeAll();
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        ProductArrayList<Product> retainCollection = new ProductArrayList<>();
        retainCollection.add(new Product("test", new BigDecimal("12"), "uk"));
        retainCollection.add(new Product("test", new BigDecimal("13"), "uk"));
        products.retainAll(retainCollection);
        Assert.assertEquals(new Product("test", new BigDecimal("12"), "uk"), products.get(0));
        Assert.assertEquals(1, products.size());
    }

}
