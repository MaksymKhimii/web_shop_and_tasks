package controller.pages;

import controller.Command;
import model.service.CaptchaService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * in this class there is a redirect
 * to the registration page when "Sign Up" button in navbar is clicked.
 *
 * Also, the captcha generation method is called here and a delay starts
 * before deleting the captcha in case of successful registration
 * or if 60 seconds have passed since the button was pressed
 * @see CaptchaService
 */
public class SignUpPage implements Command {
    public static HashMap<Integer, String> captcha;

    public static HashMap<Integer, String> getCaptcha() {
        return captcha;
    }

    public static String getCaptchaValue(int key) {
        return captcha.get(key);
    }

    public static Integer getCaptchaId(HashMap<Integer, String> captchaHandler) {
        return captchaHandler.keySet().stream().findFirst().get();
    }


    @Override
    public String execute(HttpServletRequest request) {
        captcha = CaptchaService.generateCaptcha();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                CaptchaService.deleteCurrentCaptcha(request);
            }
        };
        //timer for task of deleting current captcha in 60 seconds
        timer.schedule(task, 60 * 1000);
        request.setAttribute("hiddenCaptcha", SignUpPage.getCaptchaId(captcha));
        return "/WEB-INF/user/signUp.jsp";
    }
}