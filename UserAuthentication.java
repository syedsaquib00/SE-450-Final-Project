import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {
    private Map<String, String> users;

    public UserAuthentication() {
        users = new HashMap<>();
    }

    public YourUserClass register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Registration failed. Username already exists.");
            return null;
        } else {
            users.put(username, password);
            System.out.println("Registration successful for username: " + username);
            return new YourUserClass(username);  // Replace YourUserClass with the actual name of your User class
        }
    }

    public YourUserClass login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful for username: " + username);
            return new YourUserClass(username);  // Replace YourUserClass with the actual name of your User class
        } else {
            System.out.println("Login failed. Invalid username or password.");
            return null;
        }
    }

    public static void main(String[] args) {
        UserAuthentication auth = new UserAuthentication();
        try (Scanner scanner = new Scanner(System.in)) {
			YourUserClass user = null;

			System.out.println("Register - Enter Username:");
			String regUsername = scanner.nextLine();
			System.out.println("Register - Enter Password:");
			String regPassword = scanner.nextLine();
			user = auth.register(regUsername, regPassword);

			if (user != null) {
			    System.out.println("Login - Enter Username:");
			    String loginUsername = scanner.nextLine();
			    System.out.println("Login - Enter Password:");
			    String loginPassword = scanner.nextLine();
			    auth.login(loginUsername, loginPassword);
			}
		}

        // Other functionalities can be added here based on login success
    }
}

// Replace YourUserClass with the actual name of your User class
class YourUserClass {
    private String username;

    public YourUserClass(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
