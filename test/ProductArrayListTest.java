import com.epam.khimii.task1.Entity.Product;
import com.epam.khimii.task1.List.ProductArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.math.BigDecimal;

public class ProductArrayListTest {

    @Test
    public void shouldAddToStart() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(0, expected);
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldAddToEnd() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(products.size(), expected);
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldAddToMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("11"), "uk"));
        products.add(0, new Product("test", new BigDecimal("12"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(1, expected);
        Assert.assertEquals(expected, products.get(1));
    }

    @Test
    public void shouldAddElement() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        Assert.assertEquals(expected, products.get(3));
        Assert.assertEquals(4, products.size());
    }

    @Test
    public void shouldRemoveFirst() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(expected);
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        products.remove(0);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldRemoveLast() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(expected);
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        products.remove(products.size() - 1);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldRemoveMiddle() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(expected);
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        products.remove(1);
        Assert.assertEquals(2, products.size());
        Assert.assertNotEquals(expected, products.get(1));
    }

    @Test
    public void shouldReturnCorrectlyByIndex() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        Assert.assertEquals(expected, products.get(2));
    }

    @Test
    public void shouldRemoveCorrectlyByObject() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        products.remove(expected);
        Assert.assertEquals(2, products.size());
    }

    @Test
    public void shouldNotRemoveIfNotObject() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("13"), "uk"));
        products.remove(new Product("test", new BigDecimal("15"), "uk"));
        Assert.assertEquals(3, products.size());
        Assert.assertFalse(products.remove(new Product("test", new BigDecimal("15"), "uk")));
    }

    @Test
    public void shouldCorrectlyAddCollection() {
        ProductArrayList<Product> addingCollection = new ProductArrayList<>();
        addingCollection.add(new Product("test", new BigDecimal("10"), "uk"));
        addingCollection.add(new Product("test", new BigDecimal("11"), "uk"));
        addingCollection.add(new Product("test", new BigDecimal("12"), "uk"));
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.addAll(addingCollection);
        Assert.assertEquals(addingCollection.toArray(), products.toArray());
        Assert.assertEquals(3, products.size());
    }

    @Test
    public void shouldCorrectlyRemoveCollection() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        ProductArrayList<Product> removingCollection = new ProductArrayList<>();
        removingCollection.add(new Product("test", new BigDecimal("10"), "uk"));
        removingCollection.add(new Product("test", new BigDecimal("11"), "uk"));
        products.removeAll(removingCollection);
        Assert.assertEquals(new Product("test", new BigDecimal("12"), "uk"), products.get(0));
        Assert.assertEquals(1, products.size());
    }

    @Test
    public void shouldCorrectlyRetainCollection() {
        ProductArrayList<Product> products = new ProductArrayList<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
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
