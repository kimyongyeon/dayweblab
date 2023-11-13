package main.java.shopping;

import main.java.shopping.domain.model.Customer;
import main.java.shopping.domain.model.order.Order;
import main.java.shopping.domain.model.Product;
import main.java.shopping.domain.repository.ProductRepository;

import java.util.Map;

public class Application {

    public static void main(String[] args) {

        ProductRepository productRepository = initProducts();

        Customer customer1 = new Customer("사용자1", "메일주소1", "배송주소1");
        Customer customer2 = new Customer("사용자2", "메일주소2", "배송주소2");
        Customer customer3 = new Customer("사용자3", "메일주소3", "배송주소3");

        Order order1 = new Order(customer1);
        Order order2 = new Order(customer2);
        Order order3 = new Order(customer3);

        order1.addProduct(productRepository.showProduct("상품1"), 10); //이후 상품1 재고 0개
        order1.addProduct(productRepository.showProduct("상품2"), 4);

        order2.addProduct(productRepository.showProduct("상품3"), 5);
        order2.addProduct(productRepository.showProduct("상품4"), 3);

        order3.addProduct(productRepository.showProduct("상품5"), 6);
        order3.addProduct(productRepository.showProduct("상품1"), 2); //상품1의 재고가 부족함

        System.out.print("<주문 전>");
        productRepository.printStatus();

        System.out.println("<사용자1 주문 후>");
        tryPlacingOrder(customer1, order1);
        productRepository.printStatus();

        System.out.println("<사용자2 주문 후>");
        tryPlacingOrder(customer2, order2);
        productRepository.printStatus();

        System.out.println("<사용자3 주문 후>");
        tryPlacingOrder(customer3, order3);
        productRepository.printStatus();
    }

    private static void tryPlacingOrder(Customer customer1, Order order1) {
        try {
            customer1.placeOrder(order1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ProductRepository initProducts() {
        ProductRepository productRepository = ProductRepository.getInstance();

        productRepository.addProduct(new Product("상품1", "설명1", 1000), 10);
        productRepository.addProduct(new Product("상품2", "설명2", 2000), 9);
        productRepository.addProduct(new Product("상품3", "설명3", 3000), 8);
        productRepository.addProduct(new Product("상품4", "설명4", 4000), 7);
        productRepository.addProduct(new Product("상품5", "설명5", 5000), 6);

        return productRepository;
    }

}
