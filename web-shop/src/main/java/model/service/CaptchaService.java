package model.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Random;

/**
 * captcha service
 */
public class CaptchaService {
    private final HashMap<Integer, String> captcha = new HashMap();
    private int captchaId;

    public int getCaptchaId() {
        return captchaId;
    }

    public HashMap<Integer, String> getCaptcha() {
        return captcha;
    }

    /**
     * this method return the key of current captcha
     */
    public Integer generateCaptcha() {
        String captcha = "1234567890";
        StringBuilder captchaBuffer = new StringBuilder();
        Random random = new Random();
        while (captchaBuffer.length() < 5) {
            int index = (int) (random.nextFloat() * captcha.length());
            captchaBuffer.append(captcha.charAt(index));
        }
        captchaId = random.nextInt(10);
        this.captcha.put(captchaId, captchaBuffer.toString());
        return captchaId;
    }

    public String getCaptchaValue(int key) {
        return captcha.get(key);
    }

    public void deleteCurrentCaptcha(HttpServletRequest request) {
        captcha.remove(captchaId);
        System.out.println("The captcha was deleted");
        int newCaptchaId = generateCaptcha();
        String newCaptcha = captcha.get(newCaptchaId);
        System.out.println("newCaptcha: " + newCaptcha);
        request.setAttribute("hiddenCaptcha", newCaptcha);
    }
}