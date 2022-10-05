package model.entity;

public class User {
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public User(String login, String firstName, String lastName, String password, String email) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}