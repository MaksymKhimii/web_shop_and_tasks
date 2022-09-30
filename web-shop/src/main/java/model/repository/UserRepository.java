package model.repository;

import model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * repository with fake database
 * that will be changed
 * in next task using read database
 */
public class UserRepository {
    private List<User> users = new ArrayList<>() {
        {
            add(new User("steve123", "Steve", "Jackson", "12345", "stevejackson@gmail.com"));
            add(new User("agent007", "James", "Carrol", "54321", "jamescarrol@gmail.com"));
        }
    };

    public List<User> getUsers() {
        return users;
    }

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
