package listener;

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
        context.setAttribute("UserRepository", userRepository);
        //services
        UserService userService = new UserService(userRepository);
        context.setAttribute("UserService", userService);
        CaptchaService captchaService = new CaptchaService();
        context.setAttribute("CaptchaService", captchaService);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        context.removeAttribute("UserRepository");
        context.removeAttribute("UserService");
        context.removeAttribute("CaptchaService");
    }
}