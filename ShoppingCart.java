import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

	public static ShoppingCart getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getCartItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public void displayCart() {
		// TODO Auto-generated method stub
		
	}
}
