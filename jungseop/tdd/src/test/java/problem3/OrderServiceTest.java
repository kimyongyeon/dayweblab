package problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    PaymentProcessor paymentProcessor;

    Account account;
    Member member;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        account = new Account("123", 10000l);
        member = new Member("hwang", account);
        orderService = new OrderService(paymentProcessor);
    }

    @ParameterizedTest
    @ValueSource(longs = {10001l, 20000l, 30000l})
    @DisplayName("잔고가 결제 금액보다 적으면 예외가 발생한다.")
    void checkPaymentProcessorExceptionCase(long amount) {
        when(paymentProcessor.execute(account, amount))
                .thenThrow(new PaymentFailedException());

        assertThrows(PaymentFailedException.class,
                () -> orderService.payAmount(member, amount));
    }

    @ParameterizedTest
    @ValueSource(longs = {1000l, 9999l, 10000l})
    @DisplayName("결제 처리 로직이 성공적으로 동작하는지 검증한다.")
    void checkPaymentProcessorCorrectly(long amount) {
        when(paymentProcessor.execute(account, amount))
                .thenReturn(account.getBalance() - amount);

        assertEquals(orderService.payAmount(member, amount), 10000l - amount);
    }

}