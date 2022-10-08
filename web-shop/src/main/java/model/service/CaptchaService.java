package model.service;

import model.captcha.factory.handler.CaptchaHandler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * captcha service
 */
public class CaptchaService {
    private final Map<Integer, String> captcha = new HashMap<>();
    private CaptchaHandler captchaHandler;
    public Map<Integer, String> getCaptcha() {
        return captcha;
    }

    public Integer generateCaptcha(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        String captcha = "1234567890";
        StringBuilder captchaBuffer = new StringBuilder();
        Random random = new Random();
        while (captchaBuffer.length() < 5) {
            int index = (int) (random.nextFloat() * captcha.length());
            captchaBuffer.append(captcha.charAt(index));
        }
        int captchaId = random.nextInt(10);
        this.captcha.put(captchaId, captchaBuffer.toString());
        captchaHandler = (CaptchaHandler) context.getAttribute("captchaHandler");
        captchaHandler.save(String.valueOf(captchaId), request, response);
        return captchaId;
    }

    public String getCaptchaValue(int key) {
        return captcha.get(key);
    }

    public void updateCaptcha(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        int newCaptchaId = generateCaptcha(context, request, response);
        captchaHandler = (CaptchaHandler) context.getAttribute("captchaHandler");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                captcha.remove(Integer.parseInt(captchaHandler.extract(request)));
                captchaHandler.save(String.valueOf(newCaptchaId), request, response);
            }
        };
        timer.schedule(task, 60 * 1000);
    }
}