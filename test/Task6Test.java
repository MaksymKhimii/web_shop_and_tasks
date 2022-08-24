import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;
import com.epam.khimii.task4.container.FillStrategyContainer;
import com.epam.khimii.task4.file_handler.FileHandler;
import com.epam.khimii.task4.strategy.InputProductStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class Task6Test {
    private Scanner scanner = new Scanner(System.in);
    private UniqueProductArrayList<Product> products;
    private Product product1;

    @Before
    public void Before() throws IOException, ClassNotFoundException {
        products = new UniqueProductArrayList<>();
        products.addAll(new FileHandler().load("fileForTask6.txt"));
        product1 = new Product("apple", new BigDecimal("10"), "UKRAINE");
    }

    @Test
    public void shouldBeSameListOfProducts() {
        UniqueProductArrayList<Product> expected = new UniqueProductArrayList<>();
        expected.add(product1);
        Assert.assertEquals(products, expected);
    }

    @Test
    public void shouldFillNewRandomGoodsTest() throws IOException {
        InputProductStrategy strategy = (new FillStrategyContainer(products, scanner)).getStrategies(1);
        Product newProd = strategy.generateProduct(products);
        products.add(newProd);
        new FileHandler().save(products, "fileForTask6Save.txt");
        Assert.assertEquals(6, products.size());
    }

    @Test
    public void shouldSaveProductListInGZip() throws IOException {
        int c;
        File archive = new File("GZipTest.txt.gz");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(
                "fileForTask6.txt")));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream(archive)));
        while ((c = in.read()) != -1) {
            out.write(String.valueOf((char) c).getBytes("GBK"));
        }
        in.close();
        out.close();
        Assert.assertTrue(archive.exists());
    }
}