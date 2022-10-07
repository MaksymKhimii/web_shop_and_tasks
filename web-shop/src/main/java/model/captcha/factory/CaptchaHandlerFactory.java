package model.captcha.factory;

import model.captcha.factory.handler.CaptchaAttributeHandler;
import model.captcha.factory.handler.CaptchaCookieHandler;
import model.captcha.factory.handler.CaptchaHandler;
import model.captcha.factory.handler.CaptchaHiddenFormFieldHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * implementation of the abstract factory pattern
 * to determine how to store captcha depending
 * on the parameter in web.xml
 *
 * @see CaptchaAttributeHandler - for saving in attribute
 * @see CaptchaCookieHandler - for  saving in cookie
 * @see CaptchaHiddenFormFieldHandler - for  saving in hidden field in html
 */
public class CaptchaHandlerFactory implements CaptchaFactory {
    @Override
    public CaptchaHandler create(String stringCaptchaProperty) {
        Map<String, CaptchaHandler> captchaHandlerMap = new HashMap<>() {{
            put("attribute", new CaptchaAttributeHandler());
            put("cookie", new CaptchaCookieHandler());
            put("hiddenFormField", new CaptchaHiddenFormFieldHandler());
        }};
        return captchaHandlerMap.get(stringCaptchaProperty);
    }
}