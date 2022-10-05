package model.captcha.factory.handler;

import model.service.CaptchaService;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        CaptchaService captchaService = (CaptchaService) context.getAttribute("CaptchaService");
        Cookie[] cookies = request.getCookies();
        String captchaId;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("captcha")) {
                captchaId = cookie.getValue();
                return captchaService.getCaptchaValue(Integer.parseInt(captchaId));
            }
        }
        return null;
    }
}