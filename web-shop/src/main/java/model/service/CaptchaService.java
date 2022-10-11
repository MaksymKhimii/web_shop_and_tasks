package model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * captcha service
 */
public class CaptchaService {
    private final Map<Integer, String> captcha = new HashMap<>();

    public Map<Integer, String> getCaptcha() {
        return captcha;
    }

    public Integer generateCaptcha() {
        String captcha = "1234567890";
        StringBuilder captchaBuffer = new StringBuilder();
        Random random = new Random();
        while (captchaBuffer.length() < 5) {
            int index = (int) (random.nextFloat() * captcha.length());
            captchaBuffer.append(captcha.charAt(index));
        }
        int captchaId = random.nextInt(10);
        this.captcha.put(captchaId, captchaBuffer.toString());
        return captchaId;
    }

    public String getCaptchaValue(int key) {
        return captcha.get(key);
    }
}