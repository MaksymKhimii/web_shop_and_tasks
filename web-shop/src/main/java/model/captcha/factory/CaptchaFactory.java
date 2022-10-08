package model.captcha.factory;

import model.captcha.factory.handler.CaptchaHandler;

public interface CaptchaFactory {
    /**
     * method for creating captcha handler depending on property
     *
     * @param stringCaptchaProperty property "captchaHandler" from web.xml
     * @return CaptchaHandler
     * @see CaptchaHandler
     */
    CaptchaHandler create(String stringCaptchaProperty);
}