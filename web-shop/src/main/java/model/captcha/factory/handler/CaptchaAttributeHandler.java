package model.captcha.factory.handler;

import model.service.CaptchaService;

import javax.servlet.ServletContext;
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
        ServletContext context = request.getServletContext();
        CaptchaService captchaService = (CaptchaService) context.getAttribute("CaptchaService");
        HttpSession session = request.getSession(true);
        Integer captchaId =(Integer) session.getAttribute("captcha");
        return captchaService.getCaptchaValue(captchaId);
    }
}