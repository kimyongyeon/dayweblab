package problem2;

public class UserService {

    private final UserRepository repository = new UserRepository();

    void addUser(User user) {
        repository.create(user);
    }

    User findUserById(String id) {
        return repository.findById(id);
    }

}
