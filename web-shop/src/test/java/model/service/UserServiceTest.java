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
        userTest1 = new User().setLogin("agent008").setFirstName("Mark")
                .setLastName("Samons").setEmail("markSamons@gmail.com").setPassword("12345");
        userTest2 = new User().setLogin("steve123").setFirstName("Steve")
                .setLastName("Jackson").setEmail("stevejackson@gmail.com").setPassword("12345");
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