package main.java.shopping.domain.repository;

import main.java.shopping.domain.model.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductRepository {

    private final Map<Product, Integer> store = new LinkedHashMap<>();

    private static ProductRepository instance = new ProductRepository();

    public static ProductRepository getInstance() {
        return instance;
    }

    private ProductRepository() {

    }

    public void addProduct(Product product, int quantity) {
        store.put(product, quantity);
    }

    public Product showProduct(String name) {
        return store.keySet().stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .get();
    }

    public int updateStock(Product product, int quantity) {
        Integer currentQuantity = store.get(product);
        if (currentQuantity + quantity < 0) {
            throw new IllegalArgumentException(product.getName() + "의 재고가 부족합니다.");
        }
        store.replace(product, currentQuantity + quantity);
        return store.get(product);
    }

    public void printStatus() {
        for (Map.Entry<Product, Integer> entry : store.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
        System.out.println();
    }

}
