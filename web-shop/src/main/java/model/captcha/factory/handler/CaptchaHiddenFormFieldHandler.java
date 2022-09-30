package model.captcha.factory.handler;

import controller.pages.SignUpPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * handler for saving captcha in hidden field
 */
public class CaptchaHiddenFormFieldHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("hiddenCaptcha", captcha);
    }

    @Override
    public String extract(HttpServletRequest request) {
        int captchaId = Integer.parseInt(request.getParameter("hiddenCaptcha"));
        return SignUpPage.getCaptchaValue(captchaId);
    }
}