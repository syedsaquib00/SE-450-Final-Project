import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Product> products;
    private User user;
    
    public Order() {
        this.products = new ArrayList<>();
        // Initialize other attributes as needed
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Other attributes and methods
}
