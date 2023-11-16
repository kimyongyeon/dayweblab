package main.java.bank.domain.model;

/**
 * 고객 정보
 * 1. 고객 ID
 * 2. 이름
 */
public class Customer {

    private static long seq = 1l;

    private final long customerId;
    private final String name;

    public Customer(String name) {
        this.customerId = seq++;
        this.name = name;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
