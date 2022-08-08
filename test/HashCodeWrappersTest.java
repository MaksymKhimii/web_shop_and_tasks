import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.hashCodeWrappers.StringLengthHashCodeWrapper;
import com.epam.khimii.task3.hashCodeWrappers.StringSumElementsHashCodeWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashCodeWrappersTest {
    String name10, name11, name12, name13;
    Product product10, product11, product12, product13;
    StringLengthHashCodeWrapper lengthWrapper10, lengthWrapper11, lengthWrapper12, lengthWrapper13;
    StringSumElementsHashCodeWrapper sumWrapper10, sumWrapper11, sumWrapper12, sumWrapper13;

    @Before
    public void BeforeTest() {
        name10 = "Product10";
        name11 = "Product11";
        name12 = "Product12";
        name13 = "Product13";
        product10 = new Product("test10", new BigDecimal("10"), "uk");
        product11 = new Product("test11", new BigDecimal("11"), "uk");
        product12 = new Product("test12", new BigDecimal("12"), "uk");
        product13 = new Product("test13", new BigDecimal("13"), "uk");
        lengthWrapper10 = new StringLengthHashCodeWrapper(name10);
        lengthWrapper11 = new StringLengthHashCodeWrapper(name11);
        lengthWrapper12 = new StringLengthHashCodeWrapper(name12);
        lengthWrapper13 = new StringLengthHashCodeWrapper(name13);
        sumWrapper10 = new StringSumElementsHashCodeWrapper(name10);
        sumWrapper11 = new StringSumElementsHashCodeWrapper(name11);
        sumWrapper12 = new StringSumElementsHashCodeWrapper(name12);
        sumWrapper13 = new StringSumElementsHashCodeWrapper(name13);
    }

    @Test
    public void shouldBeSameHashMap() {
        HashMap<String, Product> map = new HashMap<>();
        map.put(name10, product10);
        map.put(name11, product11);
        map.put(name12, product12);
        map.put(name13, product13);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(product12);
        expected.add(product13);
        expected.add(product10);
        expected.add(product11);
        ArrayList<Product> actual = new ArrayList<>();
        Iterator<Map.Entry<String, Product>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Product> entry = entries.next();
            actual.add(entry.getValue());
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldBeSameLinkedHashMap() {
        LinkedHashMap<String, Product> map = new LinkedHashMap<>();
        map.put(name10, product10);
        map.put(name11, product11);
        map.put(name12, product12);
        map.put(name13, product13);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(product10);
        expected.add(product11);
        expected.add(product12);
        expected.add(product13);
        ArrayList<Product> actual = new ArrayList<>();
        Iterator<Map.Entry<String, Product>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Product> entry = entries.next();
            actual.add(entry.getValue());
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldBeSameHashMapByLength() {
        HashMap<StringLengthHashCodeWrapper, Product> map = new HashMap<>();
        map.put(lengthWrapper10, product10);
        map.put(lengthWrapper11, product11);
        map.put(lengthWrapper12, product12);
        map.put(lengthWrapper13, product13);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(product10);
        expected.add(product11);
        expected.add(product12);
        expected.add(product13);
        ArrayList<Product> actual = new ArrayList<>();
        Iterator<Map.Entry<StringLengthHashCodeWrapper, Product>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<StringLengthHashCodeWrapper, Product> entry = entries.next();
            actual.add(entry.getValue());
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldBeSameLinkedHashMapByLength() {
        LinkedHashMap<StringLengthHashCodeWrapper, Product> map = new LinkedHashMap<>();
        map.put(lengthWrapper10, product10);
        map.put(lengthWrapper11, product11);
        map.put(lengthWrapper12, product12);
        map.put(lengthWrapper13, product13);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(product10);
        expected.add(product11);
        expected.add(product12);
        expected.add(product13);
        ArrayList<Product> actual = new ArrayList<>();
        Iterator<Map.Entry<StringLengthHashCodeWrapper, Product>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<StringLengthHashCodeWrapper, Product> entry = entries.next();
            actual.add(entry.getValue());
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldBeSameHashMapBySum() {
        HashMap<StringSumElementsHashCodeWrapper, Product> map = new HashMap<>();
        map.put(sumWrapper10, product10);
        map.put(sumWrapper11, product11);
        map.put(sumWrapper12, product12);
        map.put(sumWrapper13, product13);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(product10);
        expected.add(product11);
        expected.add(product12);
        expected.add(product13);
        ArrayList<Product> actual = new ArrayList<>();
        Iterator<Map.Entry<StringSumElementsHashCodeWrapper, Product>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<StringSumElementsHashCodeWrapper, Product> entry = entries.next();
            actual.add(entry.getValue());
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldBeSameLinkedHashMapBySum() {
        LinkedHashMap<StringSumElementsHashCodeWrapper, Product> map = new LinkedHashMap<>();
        map.put(sumWrapper10, product10);
        map.put(sumWrapper11, product11);
        map.put(sumWrapper12, product12);
        map.put(sumWrapper13, product13);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(product10);
        expected.add(product11);
        expected.add(product12);
        expected.add(product13);
        ArrayList<Product> actual = new ArrayList<>();
        Iterator<Map.Entry<StringSumElementsHashCodeWrapper, Product>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<StringSumElementsHashCodeWrapper, Product> entry = entries.next();
            actual.add(entry.getValue());
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
