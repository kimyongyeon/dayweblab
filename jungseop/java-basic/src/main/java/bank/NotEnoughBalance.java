package main.java.bank;

public class NotEnoughBalance extends RuntimeException{

    public NotEnoughBalance(String message) {
        super(message);
    }
}
