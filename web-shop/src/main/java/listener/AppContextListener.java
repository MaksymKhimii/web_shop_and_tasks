package listener;

import model.captcha.factory.CaptchaFactory;
import model.captcha.factory.CaptchaHandlerFactory;
import model.captcha.factory.handler.CaptchaHandler;
import model.repository.UserRepository;
import model.service.CaptchaService;
import model.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        UserRepository userRepository = new UserRepository();
        context.setAttribute("userRepository", userRepository);
        UserService userService = new UserService(userRepository);
        context.setAttribute("userService", userService);
        CaptchaService captchaService = new CaptchaService();
        context.setAttribute("captchaService", captchaService);
        CaptchaFactory captchaFactory = new CaptchaHandlerFactory();
        CaptchaHandler captchaHandler = captchaFactory.create(context.getInitParameter("captchaHandler"));
        context.setAttribute("captchaHandler", captchaHandler);
    }
}