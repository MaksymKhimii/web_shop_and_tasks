package model.captcha.factory.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaHandler {
    /**
     * this method save user's captchaId in different ways
     *
     * @param captchaId key to get captcha using the CaptchaService
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @see model.service.CaptchaService
     */
    void save(String captchaId, HttpServletRequest request, HttpServletResponse response);

    /**
     * method to get captchaId from handler
     *
     * @param request HttpServletRequest
     * @return captchaId
     */
    String extract(HttpServletRequest request);
}