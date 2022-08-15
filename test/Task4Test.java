import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.BufferRepositoryImpl;
import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;
import com.epam.khimii.task4.service.BasketServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Task4Test {
    ApplicationContext applicationContext = new ApplicationContext();
    Product product1, product2, product3, product4, product5, product6;
    public Basket basket;
    public Buffer buffer;
    private Optional<Order> order;
    private List<Product> products;
    ProductRepositoryImpl productRepository;
    BasketRepositoryImpl basketRepositoryImpl;
    public static OrderRepositoryImpl orderRepositoryImpl;
    BasketServiceImpl basketServiceImpl;
    BufferRepositoryImpl bufferRepository;

    @Before
    public void BeforeTest() {
        product1 = new Product("apple", 11.0, "uk");
        product2 = new Product("banana", 12.0, "uk");
        product3 = new Product("potato", 13.0, "uk");
        product4 = new Product("tomato", 14.0, "uk");
        product5 = new Product("peach", 15.0, "uk");
        product6 = new Product("olive", 16.0, "ua");
        productRepository = new ProductRepositoryImpl();
        products = productRepository.getProducts();
        basket = new Basket();
        buffer = new Buffer();
        bufferRepository = new BufferRepositoryImpl();
        basketRepositoryImpl = new BasketRepositoryImpl(bufferRepository, products);
        orderRepositoryImpl = new OrderRepositoryImpl(basketRepositoryImpl.getBasket());
        basketServiceImpl = new BasketServiceImpl(basketRepositoryImpl);
        applicationContext.initAll();
    }

    @Test
    public void addToBasketTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        Assert.assertEquals(2, basketRepositoryImpl.size());
        basket.clear();
    }

    @Test
    public void buyBasketTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        double actual = basketServiceImpl.buyBasket();
        Assert.assertEquals(0, basketRepositoryImpl.size());
        Assert.assertEquals(167.0, actual, 0);
        basket.clear();
    }

    @Test
    public void buyEmptyBasketTest() {
        double actual = basketServiceImpl.buyBasket();
        Assert.assertEquals(0, basketRepositoryImpl.size());
        Assert.assertEquals(-1, actual, 0);
        basket.clear();
    }

    @Test
    public void showBasketTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        Assert.assertEquals("""
                Product{name='apple', quantity='1'}\r
                Product{name='potato', quantity='12'}\r
                """, basket.toString());
        basket.clear();
    }

    @Test
    public void showBufferTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        basketRepositoryImpl.addToBasket(product2.getName(), 11);
        basketRepositoryImpl.addToBasket(product4.getName(), 12);
        basketRepositoryImpl.addToBasket(product5.getName(), 7);
        basketRepositoryImpl.addToBasket(product6.getName(), 99);
        Assert.assertEquals("""
                Product{name='potato', quantity='12'}\r
                Product{name='banana', quantity='11'}\r
                Product{name='tomato', quantity='12'}\r
                Product{name='peach', quantity='7'}\r
                Product{name='olive', quantity='99'}\r
                """, buffer.toString());
        basket.clear();
    }

    @Test
    public void doOrderTest() {
        basketRepositoryImpl.addToBasket(product2.getName(), 11);
        basketRepositoryImpl.addToBasket(product4.getName(), 2);
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        order = orderRepositoryImpl.getOrderByTime(date);
        Assert.assertEquals("Optional[Order{date=" + date + ", " +
                "order={" + product2.getName() + "=11, " + product4.getName() + "=2}}]", order.toString());
        basket.clear();
    }

    @Test
    public void showOrderByTimeRangeTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        List<Order> actual = orderRepositoryImpl.getOrderByRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        Assert.assertEquals("[Order{date=" + date + ", order={" + product1.getName() + "=1}}]", actual.toString());
        basket.clear();
    }

    @Test
    public void showOrderByTimeTest() {
        basketRepositoryImpl.addToBasket(product2.getName(), 17);
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        Optional<Order> actual = orderRepositoryImpl.getOrderByTime(date);
        Assert.assertEquals("Optional[Order{date=" + date + ", order={" + product2.getName() + "=17}}]", actual.toString());
        basket.clear();
    }
}


