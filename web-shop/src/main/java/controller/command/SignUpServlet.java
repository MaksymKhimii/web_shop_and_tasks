package controller.command;

import model.captcha.factory.handler.CaptchaHandler;
import model.entity.User;
import model.repository.extractor.UserExtractor;
import model.service.CaptchaService;
import model.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserExtractor extractor;

    @Override
    public void init() {
        extractor = new UserExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();
        CaptchaService captchaService = (CaptchaService) context.getAttribute("captchaService");
        int captchaId = captchaService.generateCaptcha(context);
        captchaService.updateCaptcha(request);
        CaptchaHandler captchaHandler = (CaptchaHandler) context.getAttribute("captchaHandler");
        captchaHandler.save(String.valueOf(captchaId), request, response);
        response.sendRedirect("/signUpPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = "/error";
        ServletContext context = request.getServletContext();
        UserService userService = (UserService) context.getAttribute("userService");
        CaptchaHandler captchaHandler = (CaptchaHandler) context.getAttribute("captchaHandler");
        String captcha = captchaHandler.extract(request);
        String captchaFromUser = request.getParameter("captchaInput");
        if (captchaFromUser.equals(captcha)) {
            User newUser = extractor.extract(request);
            userService.registerNewUser(newUser);
            if (userService.checkUser(newUser)) {
                path = "/login";
            }
        }
        response.sendRedirect(path);
    }
}