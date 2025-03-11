package LoggingExample.Example;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        // Реализация будет добавлена в соответствии с заданием
    }

    public void listCustomers() {
        // Реализация будет добавлена в соответствии с заданием
    }

    public void removeCustomer(String name) {
        // Реализация будет добавлена в соответствии с заданием
    }

    public int getCustomerCount() {
        return storage.size();
    }
}

class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

