import com.epam.khimii.task4.entity.Products;
import com.epam.khimii.task4.repository.BasketRepository;
import com.epam.khimii.task4.repository.BufferRepository;
import com.epam.khimii.task4.repository.OrderRepository;
import com.epam.khimii.task4.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class Task4Test {
    Products product1, product2, product3, product4;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void BeforeTest() {
        ProductRepository.addAll();
        product1 = new Products("apple", 11.0, "uk");
        product2 = new Products("banana", 12.0, "uk");
        product3 = new Products("potato", 13.0, "uk");
        product4 = new Products("tomato", 14.0, "uk");
        System.setOut(new PrintStream(output));
    }

    @Test
    public void addToBasketTest() {
        BasketRepository.addToBasket(product1.getName(), 1);
        BasketRepository.addToBasket(product3.getName(), 12);
        Assert.assertEquals(2, BasketRepository.size());
    }

    @Test
    public void buyBasketTest() {
        BasketRepository.addToBasket(product1.getName(), 1);
        BasketRepository.addToBasket(product2.getName(), 2);
        BasketRepository.buyBasket();
        Assert.assertEquals(0, BasketRepository.size());
        Assert.assertEquals("Общая сумма заказа: 35.0\r\n", output.toString());
    }

    @Test
    public void buyEmptyBasketTest() {
        BasketRepository.buyBasket();
        Assert.assertEquals(0, BasketRepository.size());
        Assert.assertEquals("В корзине пусто, купить нельзя\r\n", output.toString());
    }

    @Test
    public void showBasketTest() {
        BasketRepository.addToBasket(product1.getName(), 1);
        BasketRepository.addToBasket(product3.getName(), 12);
        BasketRepository.printBasket();
        Assert.assertEquals("""
                Товары в корзине:\r
                Product{name='apple', quantity='1'}\r
                Product{name='potato', quantity='12'}\r
                """, output.toString());
    }

    @Test
    public void showBufferTest() {
        BasketRepository.addToBasket(product1.getName(), 1);
        BasketRepository.addToBasket(product3.getName(), 12);
        BasketRepository.addToBasket(product2.getName(), 11);
        BasketRepository.addToBasket(product4.getName(), 12);
        BufferRepository.printBuffer();
        Assert.assertEquals("""
                Последние 3 products в корзине:\r
                Product{name='potato', quantity='12'}\r
                Product{name='banana', quantity='11'}\r
                Product{name='tomato', quantity='12'}\r
                """, output.toString());
    }

    @Test
    public void doOrderTest() {
        BasketRepository.addToBasket(product2.getName(), 11);
        BasketRepository.addToBasket(product4.getName(), 2);
        LocalDateTime date = LocalDateTime.now();
        OrderRepository.doOrder(date);
        Assert.assertEquals("", output.toString());
    }

    @Test
    public void showOrderByTimeRangeTest() {
        BasketRepository.addToBasket(product1.getName(), 1);
        BasketRepository.addToBasket(product3.getName(), 12);
        LocalDateTime date = LocalDateTime.now();
        OrderRepository.doOrder(date);
        OrderRepository.getOrderByRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        Assert.assertEquals("""
                Product{name='apple', quantity='1'}\r
                Product{name='potato', quantity='12'}\r
                """, output.toString());
    }
}
