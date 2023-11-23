package problem2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<User> store = new ArrayList<>();

    void create(User user) {
        store.add(user);
    }

    User findById(String id) {
        return store.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException());
    }

}
