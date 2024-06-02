import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserAuthentication {
    private List<YourUserClass> users = new ArrayList<>();

    public YourUserClass register(String username, String password) {
        for (YourUserClass user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return null;
            }
        }
        YourUserClass newUser = new YourUserClass(username, password);
        users.add(newUser);
        return newUser;
    }

    public YourUserClass login(String username, String password) {
        for (YourUserClass user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }
}

class YourUserClass {
    private String username;
    private String password;

    public YourUserClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

public class Main {
    private static List<Product> availableProducts = new ArrayList<>();

    public static void main(String[] args) {
        initializeProducts();
        UserAuthentication auth = new UserAuthentication();
        try (Scanner scanner = new Scanner(System.in)) {
            YourUserClass user = null;

            // Register
            System.out.println("Register - Enter Username:");
            String regUsername = scanner.nextLine();
            System.out.println("Register - Enter Password:");
            String regPassword = scanner.nextLine();
            user = auth.register(regUsername, regPassword);

            if (user != null) {
                // Login
                System.out.println("Login - Enter Username:");
                String loginUsername = scanner.nextLine();
                System.out.println("Login - Enter Password:");
                String loginPassword = scanner.nextLine();
                user = auth.login(loginUsername, loginPassword);

                if (user != null) {
                    // Adding products to the cart
                    ShoppingCart cart = new ShoppingCart();
                    boolean addingProducts = true;

                    while (addingProducts) {
                        System.out.println("Available Products:");
                        for (int i = 0; i < availableProducts.size(); i++) {
                            Product product = availableProducts.get(i);
                            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
                        }
                        System.out.println("Enter the number of the product to add to the cart (or '0' to finish):");
                        int productChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (productChoice == 0) {
                            addingProducts = false;
                            break;
                        }

                        if (productChoice > 0 && productChoice <= availableProducts.size()) {
                            cart.addProduct(availableProducts.get(productChoice - 1));
                            System.out.println("Item added successfully: " + availableProducts.get(productChoice - 1).getName());
                        } else {
                            System.out.println("Invalid choice, please select a valid product number.");
                        }
                    }

                    // Select payment method
                    System.out.println("Select payment method: (1) Credit Card, (2) PayPal, (3) Cash on Delivery");
                    int paymentMethod = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String paymentMethodName = "";

                    switch (paymentMethod) {
                        case 1:
                            paymentMethodName = "Credit Card";
                            break;
                        case 2:
                            paymentMethodName = "PayPal";
                            break;
                        case 3:
                            paymentMethodName = "Cash on Delivery";
                            break;
                        default:
                            System.out.println("Invalid payment method selected.");
                            return;
                    }

                    // Display cart contents and payment method
                    System.out.println("Products in Cart:");
                    for (Product product : cart.getProducts()) {
                        System.out.println("- " + product.getName() + " - $" + product.getPrice());
                    }
                    System.out.println("Selected payment method: " + paymentMethodName);

                    // Simulate payment
                    boolean paymentSuccessful = simulatePayment(cart.calculateTotalPrice());

                    if (paymentSuccessful) {
                        System.out.println("Payment successful! Thank you for shopping with us.");
                    } else {
                        System.out.println("Payment failed. Please try again.");
                    }
                } else {
                    System.out.println("Login failed.");
                }
            } else {
                System.out.println("Registration failed.");
            }
        }
    }

    // Initialize products
    private static void initializeProducts() {
        availableProducts.add(new Product("Laptop", 999));
        availableProducts.add(new Product("Smartphone", 7999));
        availableProducts.add(new Product("Headphones", 199));
        availableProducts.add(new Product("Smartwatch", 299));
        availableProducts.add(new Product("Tablet", 499));
        availableProducts.add(new Product("Camera", 599));
        availableProducts.add(new Product("Printer", 149));
        availableProducts.add(new Product("Monitor", 249));
        availableProducts.add(new Product("Keyboard", 49));
        availableProducts.add(new Product("Mouse", 39));
    }

    // Simulate payment process
    private static boolean simulatePayment(double totalPrice) {
        // Simulate payment process
        System.out.println("Total amount to be paid: $" + totalPrice);
        // Assuming payment always succeeds in this simulation
        return true;
    }
}
