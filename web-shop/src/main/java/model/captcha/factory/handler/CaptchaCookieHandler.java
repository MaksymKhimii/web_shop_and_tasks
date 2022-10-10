package model.captcha.factory.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * handler for saving captchaId in cookie
 *
 * @see CaptchaHandler
 */
public class CaptchaCookieHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("captchaId", captcha);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
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