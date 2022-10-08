package model.repository;

import model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * repository with fake database
 * that will be changed
 * in next task using read database
 *
 * @see User
 */
public class UserRepository {
    private List<User> users = new ArrayList<>() {
        {
            add(new User()
                    .setLogin("steve123")
                    .setFirstName("Steve")
                    .setLastName("Jackson")
                    .setEmail("stevejackson@gmail.com")
                    .setPassword("12345"));
            add(new User()
                    .setLogin("agent007")
                    .setFirstName("James")
                    .setLastName("Carrol")
                    .setEmail("jamescarrol@gmail.com")
                    .setPassword("54321"));
        }
    };

    public boolean isUserExists(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserExists(User user) {
        return users.contains(user);
    }

    public void addUser(User user) {
        if (isUserExists(user)) {
            return;
        }
        users.add(user);
    }
}