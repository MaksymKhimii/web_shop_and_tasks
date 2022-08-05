import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class UniqueProductArrayListTest {

    Product product10, product11, product12, product13 = null;

    @Before
    public void BeforeTest() {
        product10 = new Product("test10", new BigDecimal("10"), "uk");
        product11 = new Product("test11", new BigDecimal("11"), "uk");
        product12 = new Product("test12", new BigDecimal("12"), "uk");
        product13 = new Product("test13", new BigDecimal("13"), "uk");
    }

    /**
     *
     * should not add one product twice(if it exists - not add)
     */
    @Test
    public void addingTest() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(product10);
        products.add(product10);

        Assert.assertEquals(1, products.size());
    }

    /**
     *
     * should not add one product twice by index(if it exists - not add)
     */
    @Test
    public void addingByIndexTest() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(0, product10);
        products.add(1, product10);

        Assert.assertEquals(1, products.size());
    }

    /**
     * should not set value if it exists in the arraylist
     */
    @Test
    public void settingNotUniqTest() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(product10);
        products.add(product11);
        products.set(1, product10);

        Assert.assertEquals(product11, products.get(1));
    }

    /**
     * should add all unique collection
     */
    @Test
    public void addAllUniqCollection() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();
        UniqueProductArrayList<Product> collection = new UniqueProductArrayList<>();

        products.add(product10);
        collection.add(product11);
        collection.add(product12);

        Assert.assertTrue(products.addAll(collection));
    }

    /**
     * should not add all not unique collection
     */
    @Test
    public void addAllNotUniqCollection() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();
        UniqueProductArrayList<Product> collection = new UniqueProductArrayList<>();

        products.add(product10);
        products.add(product11);
        collection.add(product12);
        collection.add(product11);
        collection.add(product13);

        Assert.assertTrue(products.addAll(collection));
        Assert.assertEquals(4, products.size());
    }


}
