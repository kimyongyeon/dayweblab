package problem4;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import problem1.CalculatorTest;
import problem2.UserServiceTest;
import problem3.OrderServiceTest;

@Suite
@SelectClasses({CalculatorTest.class, UserServiceTest.class, OrderServiceTest.class})
@SuiteDisplayName("CalculatorTest, UserServiceTest, OrderServiceTest의 테스트 코드를 실행한다.")
public class TestSuiteRunner {
}
