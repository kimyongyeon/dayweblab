package problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 정수의 합이 올바르게 반환되는지 확인한다.")
    void checkAddCorrectly() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.add(3, 4), 7);
    }

    @Test
    @DisplayName("두 정수의 합이 기댓값과 다르다.")
    void checkAddExpectedWrong() {
        Calculator calculator = new Calculator();
        assertNotEquals(calculator.add(4, 5), 10);
    }

}