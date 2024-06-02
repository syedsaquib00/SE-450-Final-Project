import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<String, Product> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProductById(String productId) {
        return products.get(productId);
    }

	public void addProduct1(Product product1) {
		// TODO Auto-generated method stub
		
	}

	public void displayProducts() {
		// TODO Auto-generated method stub
		
	}

    // Other methods for managing the catalog
}
