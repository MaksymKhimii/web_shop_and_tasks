package model.captcha.factory.handler;

import controller.pages.SignUpPage;

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
        Cookie[] cookies = request.getCookies();
        String captchaId;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("captcha")) {
                captchaId = cookie.getValue();
                return SignUpPage.getCaptchaValue(Integer.parseInt(captchaId));
            }
        }
        //What exception should be here? custom exception?
        return null;
    }
}