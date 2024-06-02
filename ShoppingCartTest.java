import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Shirt", 19.99);
        product2 = new Product("Watch", 149.99);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> cartItems = cart.getProducts();
        assertEquals(2, cartItems.size());
        assertTrue(cartItems.contains(product1));
        assertTrue(cartItems.contains(product2));
    }

    @Test
    public void testCalculateTotalPrice() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        double totalPrice = cart.calculateTotalPrice();
        assertEquals(169.98, totalPrice, 0.001);
    }

    // Additional tests for getInstance(), getCartItems(), and displayCart() can be added here
}
