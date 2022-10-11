package model.captcha.factory.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

/**
 * handler for saving captchaId in cookie
 *
 * @see CaptchaHandler
 */
public class CaptchaCookieHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("captchaId", captcha);
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                cookie.setMaxAge(0);
                System.out.println("the captcha was removed");
            }
        };
        timer.schedule(task, 30 * 1000);
    }

    @Override
    public String extract(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("captchaId"))
                .map(Cookie::getValue)
                .findAny()
                .orElse("");
    }
}