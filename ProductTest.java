import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testGetSetName() {
        Product product = new Product("TestProduct", 29.99);
        assertEquals("TestProduct", product.getName());
        
        product.setName("UpdatedProduct");
        assertEquals("UpdatedProduct", product.getName());
    }

    @Test
    public void testGetSetPrice() {
        Product product = new Product("TestProduct", 29.99);
        assertEquals(29.99, product.getPrice(), 0.001);
        
        product.setPrice(39.99);
        assertEquals(39.99, product.getPrice(), 0.001);
    }

    @Test
    public void testGetProductId() {
        Product product = new Product("TestProduct", 29.99);
        assertNull(product.getProductId()); // Assuming the initial implementation returns null
        
        // You might modify this test based on the actual logic of getProductId()
        // For instance, if getProductId() should return a specific format or value, adjust the assertion accordingly
    }
}
