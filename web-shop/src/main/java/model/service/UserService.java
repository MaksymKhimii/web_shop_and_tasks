package model.service;

import model.entity.User;
import model.repository.UserRepository;

/**
 * user service
 *
 * @see UserRepository
 */
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerNewUser(User user) {
        if (userRepository.isUserExists(user)) {
            return;
        }
        userRepository.addUser(user);
    }

    public boolean checkUser(User user) {
        return userRepository.isUserExists(user.getLogin());
    }
}