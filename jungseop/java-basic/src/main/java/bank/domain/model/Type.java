package main.java.bank.domain.model;

public enum Type {

    WITHDRAWAL("출금"),
    DEPOSIT("입금");

    private final String description;

    Type(String description) {
        this.description = description;
    }
}
