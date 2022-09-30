package model.captcha.captcha.handler;

import model.captcha.factory.handler.CaptchaCookieHandler;
import model.captcha.factory.handler.CaptchaHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaCookieHandlerTest {
    private CaptchaHandler captchaHandler;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String captcha;
    private Cookie cookie;

    @Before
    public void beforeTest() {
        captchaHandler = new CaptchaCookieHandler();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        captcha = "12345";
        cookie = Mockito.mock(Cookie.class);
    }

    @Test
    public void saveTest() {
        captchaHandler.save(captcha, request, response);
        Mockito.verify(cookie);
    }
}
