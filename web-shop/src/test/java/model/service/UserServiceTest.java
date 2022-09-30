package model.service;

import model.entity.User;
import model.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;
    private User userTest1, userTest2;

    @Before
    public void beforeTest() {
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
        userTest1 = new User("agent008", "Mark", "Samons", "12345", "markSamons@gmail.com");
        userTest2 = new User("steve123", "Steve", "Jackson", "12345", "stevejackson@gmail.com");
    }

    @Test
    public void RegisterNewUserTest() {
        userService.registerNewUser(userTest1);
        Assert.assertTrue(userRepository.isUserExists(userTest1));
    }

    @Test
    public void checkUserNotExistsTest() {
        Assert.assertFalse(userService.checkUser(userTest1));
    }

    @Test
    public void checkUserExistsTest() {
        Assert.assertTrue(userService.checkUser(userTest2));
    }
}