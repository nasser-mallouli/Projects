package swt.scrum.user.boundary;

import swt.scrum.user.domain.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserController {
    List<User> users = Stream.of(new User()).collect(Collectors.toList());

    private List<User> getAllUsers() {
        return users;
    }

    public User create(User user) {
        users.add(user);
        return user;
    }
}
