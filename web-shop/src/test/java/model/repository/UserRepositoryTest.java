package model.repository;

import model.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private User userTest1, userTest2;

    @Before
    public void beforeTest() {
        userRepository = new UserRepository();
        userTest1 = new User("agent008", "Mark", "Samons", "12345", "markSamons@gmail.com");
        userTest2 = new User("steve123", "Steve", "Jackson", "12345", "stevejackson@gmail.com");
    }

    @Test
    public void isUserNotExistsByLoginTest() {
        boolean actual = userRepository.isUserExists(userTest1.getLogin());
        Assert.assertFalse(actual);
    }

    @Test
    public void isUserExistsByLoginTest() {
        boolean actual = userRepository.isUserExists(userTest2.getLogin());
        Assert.assertTrue(actual);
    }

    @Test
    public void isUserNotExistsByUserTest() {
        boolean actual = userRepository.isUserExists(userTest1);
        Assert.assertFalse(actual);
    }

    @Test
    public void isUserExistsByUserTest() {
        boolean actual = userRepository.isUserExists(userTest2);
        Assert.assertTrue(actual);
    }

    @Test
    public void addUserTest() {
        userRepository.addUser(userTest1);
        Assert.assertTrue(userRepository.isUserExists(userTest1));
    }
}