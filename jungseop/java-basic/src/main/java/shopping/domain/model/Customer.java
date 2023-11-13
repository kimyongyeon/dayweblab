package main.java.shopping.domain.model;

import main.java.shopping.domain.model.order.Order;
import main.java.shopping.domain.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final ProductRepository productRepository = ProductRepository.getInstance();

    private static long seq = 1L;

    private long id;
    private String name;
    private String email;
    private String shippingAddress;
    private final List<Order> orderHistory = new ArrayList<>();

    public Customer(String name, String email, String shippingAddress) {
        this.id = seq++;
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    public void placeOrder(Order order){
        order.getOrderProduct().entrySet().stream()
                .forEach(entry -> productRepository.updateStock(entry.getKey(), (-1)*entry.getValue()));
        orderHistory.add(order);
    }

    public void cancelOrder(Order order) {
        order.getOrderProduct().entrySet().stream()
                .forEach(entry -> productRepository.updateStock(entry.getKey(), entry.getValue()));
        orderHistory.remove(order);
    }

    public void updateProfile(String name, String email, String shippingAddress) {
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

}
