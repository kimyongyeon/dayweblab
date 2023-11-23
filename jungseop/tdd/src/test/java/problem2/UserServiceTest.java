package problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private static final UserService service = new UserService();

    @BeforeAll
    static void beforeAll() {
        service.addUser(new User("123", "hwang"));
        service.addUser(new User("456", "jung"));
        service.addUser(new User("789", "seop"));
    }

    @Test
    @DisplayName("아이디에 맞는 회원을 정상적으로 찾아낸다")
    void findUserByIdCorrectly() {
        Assertions.assertEquals(service.findUserById("456"), new User("456", "jung"));
    }

    @Test
    @DisplayName("아이디에 맞는 회원이 없다.")
    void findUserByIdWrong() {
        Assertions.assertThrows(UserNotFoundException.class,
                () -> service.findUserById("124"));
    }

}