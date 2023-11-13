package main.java.shopping.domain.model.order;

public enum Status {

    CONTINUE("주문 진행중"),
    COMPLETE("주문 완료");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
