package model.captcha.factory.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * handler for saving captchaId in hidden field
 * @see CaptchaHandler
 */
public class CaptchaHiddenFormFieldHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("captchaId", captcha);
    }

    @Override
    public String extract(HttpServletRequest request) {
        return request.getParameter("captchaId");
    }
}