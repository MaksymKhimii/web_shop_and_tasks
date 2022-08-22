import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;
import com.epam.khimii.task6.container.FillStrategyContainer;
import com.epam.khimii.task6.file_handler.ProductContainerFilesHandler;
import com.epam.khimii.task6.fill_product_strategy.FillProductDataStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class Task6Test {
    private UniqueProductArrayList<Product> products;
    private Product product1;

    @Before
    public void Before() throws IOException {
        products = new UniqueProductArrayList<>();
        products.addAll(new ProductContainerFilesHandler().load("fileForTask6.txt"));
        product1 = new Product("apple", new BigDecimal("10"), "UKRAINE");
    }

    @Test
    public void shouldBeSameListOfProducts(){
        UniqueProductArrayList<Product> expected = new UniqueProductArrayList<>();
        expected.add(product1);
        Assert.assertEquals(products, expected);
    }

    @Test
    public void shouldFillNewRandomGoodsTest() throws IOException {
        FillProductDataStrategy strategy = (new FillStrategyContainer()).getStrategies(1);
        products.addAll(strategy.fill(2));
        new ProductContainerFilesHandler().save(products, "fileForTask6Save.txt");
        Assert.assertEquals(products.size(), 3);
    }
}