package model.captcha.factory.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handler for saving captchaId in session
 * @see CaptchaHandler
 */
public class CaptchaAttributeHandler implements CaptchaHandler {
    @Override
    public void save(String captchaId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("captchaId", captchaId);
    }

    @Override
    public String extract(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return session.getAttribute("captchaId").toString();
    }
}