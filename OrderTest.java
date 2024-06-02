import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    private Order order;
    private List<Product> products;
    private User user;

    @BeforeEach
    public void setUp() {
        order = new Order();
        products = new ArrayList<>();
        products.add(new Product("Shirt", 19.99));
        products.add(new Product("Watch", 149.99));
        user = new User(null);
        user.setUsername("testUser");
        user.setPassword("testPassword");
    }

    @Test
    public void testGetSetProducts() {
        order.setProducts(products);
        assertEquals(products, order.getProducts());
    }

    @Test
    public void testGetSetUser() {
        order.setUser(user);
        assertEquals(user, order.getUser());
    }

    // Additional tests for other methods and attributes can be added here
}
