package model.captcha.factory.handler;

import model.service.CaptchaService;

import javax.servlet.ServletContext;
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
        ServletContext context = request.getServletContext();
        CaptchaService captchaService = (CaptchaService) context.getAttribute("captchaService");
        int captchaId = Integer.parseInt(request.getParameter("hiddenCaptcha"));
        return captchaService.getCaptchaValue(captchaId);
    }
}