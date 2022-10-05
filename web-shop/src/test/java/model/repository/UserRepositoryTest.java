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
        userTest1 = new User().setLogin("agent008").setFirstName("James").setLastName( "Carrol")
                .setEmail("jamescarrol@gmail.com").setPassword("54321");
        userTest2 = new User().setLogin("steve123").setFirstName("Steve").setLastName( "Jackson")
                .setEmail("stevejackson@gmail.com").setPassword("12345");
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
    public void addUserTest() {
        userRepository.addUser(userTest1);
        Assert.assertTrue(userRepository.isUserExists(userTest1));
    }
}