package main.java.shopping.domain.model;

public class Product {

    private static long seq = 1L;

    private final long id;
    private final String name;
    private final String description;
    private final int price;

    public Product(String name, String description, int price) {
        id = seq++;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int applyDiscount(double percentage) {
        return (int) (price * percentage);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
