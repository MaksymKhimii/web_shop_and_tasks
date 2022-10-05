package model.repository.extractor;

import model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class UserExtractor implements Extractor<User> {
    @Override
    public User extract(HttpServletRequest request) {
        String login = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new User()
                .setLogin(login)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password);
    }
}