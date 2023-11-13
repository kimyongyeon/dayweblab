package main.java.shopping.domain.model.order;

import main.java.shopping.domain.model.Customer;
import main.java.shopping.domain.model.Product;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private static long seq = 1L;

    private final long id = seq++;
    private final Map<Product, Integer> orderProduct = new HashMap<>();
    private Status status = Status.CONTINUE;
    private final LocalDate orderDate = LocalDate.now();

    private final Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public int calculateTotalAmount() {
        int totalAmount = 0;
        for (Product product : orderProduct.keySet()) {
            totalAmount += product.getPrice() * orderProduct.get(product);
        }
        return totalAmount;
    }

    public void addProduct(Product product, int quantity) {
        orderProduct.put(product, quantity);
    }

    public void removeProduct(Product product) {
        orderProduct.remove(product);
    }

    public Map<Product, Integer> getOrderProduct() {
        return orderProduct;
    }
}
