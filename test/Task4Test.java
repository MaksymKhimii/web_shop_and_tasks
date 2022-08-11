import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.entity.Product2;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;
import com.epam.khimii.task4.service.BasketService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Task4Test {
    Product2 product1, product2, product3, product4;
    public static Basket basket;
    public static Buffer buffer;
    private static Order order;
    BasketRepositoryImpl basketRepository;
    public static OrderRepositoryImpl orderRepository;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void BeforeTest() {
        ProductRepositoryImpl.initProduct();
        product1 = new Product2("apple", 11.0, "uk");
        product2 = new Product2("banana", 12.0, "uk");
        product3 = new Product2("potato", 13.0, "uk");
        product4 = new Product2("tomato", 14.0, "uk");
        basket = new Basket();
        buffer = new Buffer();
        order = new Order();
        orderRepository = new OrderRepositoryImpl();
        basketRepository = new BasketRepositoryImpl();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void addToBasketTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        basketRepository.addToBasket(product3.getName(), 12);
        Assert.assertEquals(2, BasketRepositoryImpl.size());
        basket.clear();
    }

    @Test
    public void buyBasketTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        basketRepository.addToBasket(product3.getName(), 12);
        String actual = BasketService.buyBasket();
        Assert.assertEquals(0, BasketRepositoryImpl.size());
        Assert.assertEquals("The total amount of the order: 167.0", actual);
        basket.clear();
    }

    @Test
    public void buyEmptyBasketTest() {
        String actual = BasketService.buyBasket();
        Assert.assertEquals(0, BasketRepositoryImpl.size());
        Assert.assertEquals("Basket is empty, you can't buy it", actual);
        basket.clear();
    }

    @Test
    public void showBasketTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        basketRepository.addToBasket(product3.getName(), 12);
        Assert.assertEquals("""
                Product{name='apple', quantity='1'}\r
                Product{name='potato', quantity='12'}\r
                """, basket.toString());
        basket.clear();
    }

    @Test
    public void showBufferTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        basketRepository.addToBasket(product3.getName(), 12);
        basketRepository.addToBasket(product2.getName(), 11);
        basketRepository.addToBasket(product4.getName(), 12);
        Assert.assertEquals("""
                Product{name='potato', quantity='12'}\r
                Product{name='banana', quantity='11'}\r
                Product{name='tomato', quantity='12'}\r
                """, buffer.toString());
        basket.clear();
    }

    @Test
    public void doOrderTest() {
        basketRepository.addToBasket(product2.getName(), 11);
        basketRepository.addToBasket(product4.getName(), 2);
        LocalDateTime date = LocalDateTime.now();
        orderRepository.doOrder(date);
        Assert.assertEquals("Product{name='" + date + "', quantity='{" + product2.getName() + "=11" +
                ", " + product4.getName() + "=2}'}\r\n", order.toString());
        basket.clear();
    }

    @Test
    public void showOrderByTimeRangeTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        LocalDateTime date = LocalDateTime.now();
        orderRepository.doOrder(date);
        HashMap<String, Integer> map = orderRepository.getOrderByRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        Assert.assertEquals("{" + product1.getName() + "=1}", map.toString());
        basket.clear();
    }
}

