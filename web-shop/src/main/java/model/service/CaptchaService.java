package model.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * captcha service
 */
public class CaptchaService {
    private final Map<Integer, String> captcha = new HashMap();

    public Map<Integer, String> getCaptcha() {
        return captcha;
    }

    public Integer generateCaptcha(ServletContext context) {
        String captcha = "1234567890";
        StringBuilder captchaBuffer = new StringBuilder();
        Random random = new Random();
        while (captchaBuffer.length() < 5) {
            int index = (int) (random.nextFloat() * captcha.length());
            captchaBuffer.append(captcha.charAt(index));
        }
        int captchaId = random.nextInt(10);
        this.captcha.put(captchaId, captchaBuffer.toString());
        context.setAttribute("captchaId", captchaId);
        return captchaId;
    }

    public String getCaptchaValue(int key) {
        return captcha.get(key);
    }

    public void deleteCurrentCaptcha(HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        captcha.remove(Integer.parseInt(context.getAttribute("captchaId").toString()));
        int newCaptchaId = generateCaptcha(context);
        String newCaptcha = captcha.get(newCaptchaId);
        request.setAttribute("hiddenCaptcha", newCaptcha);
    }

    public void updateCaptcha(HttpServletRequest request) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                deleteCurrentCaptcha(request);
            }
        };
        timer.schedule(task, 60 * 1000);
    }
}