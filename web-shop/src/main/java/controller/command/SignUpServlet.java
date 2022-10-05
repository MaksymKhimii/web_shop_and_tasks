package controller.command;

import model.captcha.factory.CaptchaFactory;
import model.captcha.factory.CaptchaHandlerFactory;
import model.captcha.factory.handler.CaptchaHandler;
import model.entity.User;
import model.repository.extractor.UserExtractor;
import model.service.CaptchaService;
import model.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();
        CaptchaService captchaService = (CaptchaService) context.getAttribute("CaptchaService");
        int captchaId = captchaService.generateCaptcha();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                captchaService.deleteCurrentCaptcha(request);
            }
        };
        timer.schedule(task, 60 * 1000);
        CaptchaFactory captchaFactory = new CaptchaHandlerFactory();
        CaptchaHandler captchaHandler = captchaFactory.create(getServletConfig());
        captchaHandler.save(String.valueOf(captchaId), request, response);
        request.setAttribute("hiddenCaptcha", captchaId);
        response.sendRedirect("/signUpPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = "/error";
        ServletContext context = request.getServletContext();
        UserService userService = (UserService) context.getAttribute("UserService");
        CaptchaHandler captchaHandler = (CaptchaHandler) context.getAttribute("CaptchaHandler");
        //getting captcha from current handler
        String captcha = captchaHandler.extract(request);
        String captchaFromUser = request.getParameter("captcha");
        System.out.println("captcha from user: " + captchaFromUser);
        if (captchaFromUser.equals(captcha)) {
            UserExtractor extractor = new UserExtractor();
            User newUser = extractor.extract(request);
            userService.registerNewUser(newUser);
            if (userService.checkUser(newUser)) {
                path = "/login";
            }
        }
        response.sendRedirect(path);
    }
}