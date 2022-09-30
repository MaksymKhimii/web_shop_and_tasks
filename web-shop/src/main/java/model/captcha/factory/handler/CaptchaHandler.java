package model.captcha.factory.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaHandler {
    void save(String captcha, HttpServletRequest request, HttpServletResponse response);

    String extract(HttpServletRequest request);
}