package model.captcha.factory;

import model.captcha.factory.handler.CaptchaHandler;

import javax.servlet.ServletConfig;

public interface CaptchaFactory {
    CaptchaHandler create(ServletConfig config);
}