package model.captcha.factory;

import model.captcha.factory.handler.CaptchaAttributeHandler;
import model.captcha.factory.handler.CaptchaCookieHandler;
import model.captcha.factory.handler.CaptchaHandler;
import model.captcha.factory.handler.CaptchaHiddenFormFieldHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 * implementation of the abstract factory pattern
 * to determine how to store captcha depending
 * on the parameter in web.xml
 * @see CaptchaAttributeHandler - for saving in attribute
 * @see CaptchaCookieHandler - for  saving in cookie
 * @see CaptchaHiddenFormFieldHandler - for  saving in hidden field in html
 */
public class CaptchaHandlerFactory implements CaptchaFactory {
    @Override
    public CaptchaHandler create(ServletConfig config) {
        ServletContext context = config.getServletContext();
        String stringCaptchaProperty = context.getInitParameter("captchaHandler");
        if (stringCaptchaProperty.equals("attribute")) {
            return new CaptchaAttributeHandler();
        } else if (stringCaptchaProperty.equals("cookie")) {
            return new CaptchaCookieHandler();
        }
        return new CaptchaHiddenFormFieldHandler();
    }
}