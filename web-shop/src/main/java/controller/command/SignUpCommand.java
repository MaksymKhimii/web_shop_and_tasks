package controller.command;

import controller.Command;
import model.captcha.CaptchaSignUp;
import model.captcha.factory.handler.CaptchaHandler;
import model.service.CaptchaService;
import model.service.UserService;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * a command that takes parameters
 * from the registration form
 * and registers a new user using UserService
 * @see UserService
 * @see CaptchaService
 */
public class SignUpCommand implements Command {
    private final UserService userService;

    public SignUpCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        CaptchaHandler captchaHandler = CaptchaSignUp.getCaptchaHandler();
        //getting captcha from current handler
        String captcha = captchaHandler.extract(request);
        System.out.println("real captcha: " + captcha);
        String login = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String captchaFromUser = request.getParameter("captcha");
        System.out.println("captcha from user: " + captchaFromUser);
        CaptchaService.deleteCurrentCaptcha(request);
        if (captchaFromUser.equals(captcha)) {
            User newUser = new User(login, firstName, lastName, password, email);
            userService.registerNewUser(newUser);
            if (userService.checkUser(newUser)) {
                return "/WEB-INF/user/afterValidPage.jsp";
            }
        }
        return "/WEB-INF/common/errorPage.jsp";
    }
}