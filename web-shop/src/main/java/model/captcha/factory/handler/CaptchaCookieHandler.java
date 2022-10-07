package model.captcha.factory.handler;

import model.service.CaptchaService;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * handler for saving captcha in cookie
 */
public class CaptchaCookieHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("captcha", captcha);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
    }

    @Override
    public String extract(HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        CaptchaService captchaService = (CaptchaService) context.getAttribute("captchaService");
        Cookie[] cookies = request.getCookies();
        return Arrays.stream(cookies)
                .filter(s -> s.getName().equals("captcha"))
                .map(x -> captchaService.getCaptchaValue(Integer.parseInt(x.getValue())))
                .collect(Collectors.joining());
    }
}