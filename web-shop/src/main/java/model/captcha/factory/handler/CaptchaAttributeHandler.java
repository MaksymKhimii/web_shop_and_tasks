package model.captcha.factory.handler;

import controller.pages.SignUpPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handler for saving captcha in attribute
 */
public class CaptchaAttributeHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("captcha", captcha);
    }

    @Override
    public String extract(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String captchaId = (String) session.getAttribute("captcha");
        return SignUpPage.getCaptchaValue(Integer.parseInt(captchaId));
    }
}