package problem3;

public interface PaymentProcessor {

    long execute(Account account, long amount); //외부 결제 서비스와 통신하여 결제를 처리

}
