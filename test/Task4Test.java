import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.impl.BasketRepository;
import com.epam.khimii.task4.repository.impl.OrderRepository;
import com.epam.khimii.task4.service.BasketService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

public class Task4Test {
    Product product1, product2, product3, product4, product5, product6;
    public Basket basket;
    public Buffer buffer;
    private Order order;
    BasketRepository basketRepository;
    public static OrderRepository orderRepository;
    BasketService basketService;

    @Before
    public void BeforeTest() {
        product1 = new Product("apple", 11.0, "uk");
        product2 = new Product("banana", 12.0, "uk");
        product3 = new Product("potato", 13.0, "uk");
        product4 = new Product("tomato", 14.0, "uk");
        product5 = new Product("peach", 15.0, "uk");
        product6 = new Product("olive", 16.0, "ua");
        basket = new Basket();
        buffer = new Buffer();
        order = new Order();
        basketRepository = new BasketRepository();
        orderRepository = new OrderRepository();
        basketService = new BasketService();
    }

    @Test
    public void addToBasketTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        basketRepository.addToBasket(product3.getName(), 12);
        Assert.assertEquals(2, basketRepository.size());
        basket.clear();
    }

    @Test
    public void buyBasketTest() {
        basketRepository.addToBasket(product1.getName(), 1);
        basketRepository.addToBasket(product3.getName(), 12);
        double actual = basketService.buyBasket();
        Assert.assertEquals(0, basketRepository.size());
        Assert.assertEquals(167.0, actual, 0);
        basket.clear();
    }

    @Test
    public void buyEmptyBasketTest() {
        double actual = basketService.buyBasket();
        Assert.assertEquals(0, basketRepository.size());
        Assert.assertEquals(-1, actual, 0);
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
        basketRepository.addToBasket(product5.getName(), 7);
        basketRepository.addToBasket(product6.getName(), 99);
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
        Map<String, Integer> map = orderRepository.getOrderByRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        Assert.assertEquals("{" + product1.getName() + "=1}", map.toString());
        basket.clear();
    }

    @Test
    public void showOrderByTimeTest() {
        basketRepository.addToBasket(product2.getName(), 17);
        LocalDateTime date = LocalDateTime.now();
        orderRepository.doOrder(date);
        Map<String, Integer> map = orderRepository.getOrderByTime(date);
        Assert.assertEquals("{" + product2.getName() + "=17}", map.toString());
        basket.clear();
    }
}


