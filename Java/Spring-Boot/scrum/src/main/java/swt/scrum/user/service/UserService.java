package swt.scrum.user.service;

import swt.scrum.user.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addNewUser(User user);

    void removeUser(User user);

}
