package problem3;

public class OrderService {

    private final PaymentProcessor paymentProcessor;

    OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public long payAmount(Member member, long amount) { //member가 amount만큼 금액을 결제함
        long updateAmount = paymentProcessor.execute(member.getAccount(), amount);
        member.getAccount().setBalance(updateAmount);

        return member.getAccount().getBalance();
    }

}
