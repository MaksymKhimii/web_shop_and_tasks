package model.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Random;

/**
 * captcha service
 */
public class CaptchaService {
    private static final HashMap<Integer, String> captchaHandler = new HashMap();


    public static HashMap<Integer, String> generateCaptcha() {
        String captcha = "1234567890";
        StringBuilder captchaBuffer = new StringBuilder();
        Random random = new Random();
        while (captchaBuffer.length() < 5) {
            int index = (int) (random.nextFloat() * captcha.length());
            captchaBuffer.append(captcha.charAt(index));
        }
        int id = random.nextInt(10);
        captchaHandler.put(id, captchaBuffer.toString());
        return captchaHandler;
    }

    public static Integer getCaptchaId(HashMap<Integer, String> captchaHandler) {
        return captchaHandler.keySet().stream().findFirst().get();
    }

    public static void deleteCurrentCaptcha(HttpServletRequest request) {
        int captchaId = getCaptchaId(captchaHandler);
        captchaHandler.remove(captchaId);
        System.out.println("The captcha was deleted");
        generateCaptcha();
        int newCaptchaId = getCaptchaId(captchaHandler);
        String newCaptcha = captchaHandler.get(newCaptchaId);
        System.out.println("newCaptcha: " + newCaptcha);
        request.setAttribute("hiddenCaptcha", newCaptcha);
    }
}