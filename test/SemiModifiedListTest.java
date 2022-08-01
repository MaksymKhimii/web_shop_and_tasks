import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task1.list.ProductArrayList;
import com.epam.khimii.task2.list.SemiModifiedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SemiModifiedListTest {
    Product product10, product11, product12, product13 = null;

    @Before
    public void beforeTest() {
        product10 = new Product("test10", new BigDecimal("10"), "uk");
        product11 = new Product("test11", new BigDecimal("11"), "uk");
        product12 = new Product("test12", new BigDecimal("12"), "uk");
        product13 = new Product("test13", new BigDecimal("13"), "uk");
    }

    @Test
    public void sizeTest() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        Assert.assertEquals(2, semiModifiedList.size());
    }

    @Test
    public void shouldSetObjectInMutable() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.set(1, product11);
        Assert.assertEquals(semiModifiedList.get(1), product11);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotSetObjectInImMutable() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.set(0, product11);
    }

    @Test
    public void shouldAddObject() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.add(product11);
        Assert.assertEquals(3, semiModifiedList.size());
    }

    @Test
    public void shouldAddObjectByIndex() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.add(2, product11);
        Assert.assertEquals(3, semiModifiedList.size());
    }

    @Test
    public void shouldFindIndexOfObjectInMutable() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product12);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        Assert.assertEquals(1, semiModifiedList.indexOf(product12));
    }

    @Test
    public void shouldFindIndexOfObjectInImMutable() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product12);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        Assert.assertEquals(0, semiModifiedList.indexOf(product10));
    }

    /**
     * should remove from mutable list
     */
    @Test
    public void shouldRemoveObject() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product11);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.remove(product10);
        Assert.assertEquals(1, semiModifiedList.size());
    }

    /**
     * should remove from mutable list by index
     */
    @Test
    public void shouldRemoveObjectByIndex() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.remove(1);
        Assert.assertEquals(1, semiModifiedList.size());
    }

    /**
     * should not remove from immutable list
     */
    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotRemoveObject() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product11);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product10);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.remove(product11);
    }

    /**
     * should not remove from immutable list by index
     */
    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotRemoveObjectByIndex() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product13);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        semiModifiedList.remove(0);
    }

    /**
     * should contain all in immutable list
     */
    @Test
    public void shouldContainsAllInImmutable() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        products1.add(product11);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products2.add(product13);
        ProductArrayList<Product> products3 = new ProductArrayList<>();
        products3.add(product10);
        products1.add(product11);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        Assert.assertTrue(semiModifiedList.containsAll(products3));
    }

    /**
     * should contain all in mutable list
     */
    @Test
    public void shouldContainsAllInMutable() {
        ProductArrayList<Product> products1 = new ProductArrayList<>();
        products1.add(product10);
        ProductArrayList<Product> products2 = new ProductArrayList<>();
        products1.add(product11);
        products2.add(product13);
        ProductArrayList<Product> products3 = new ProductArrayList<>();
        products3.add(product11);
        products1.add(product13);
        SemiModifiedList<Product> semiModifiedList = new SemiModifiedList(products1, products2);
        Assert.assertTrue(semiModifiedList.containsAll(products3));
    }
}
