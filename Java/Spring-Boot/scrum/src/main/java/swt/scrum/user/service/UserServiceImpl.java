package swt.scrum.user.service;

import swt.scrum.user.domain.User;
import swt.scrum.user.domain.UserRepository;

import java.util.List;

public class UserServiceImpl implements  UserService {

    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }
}
