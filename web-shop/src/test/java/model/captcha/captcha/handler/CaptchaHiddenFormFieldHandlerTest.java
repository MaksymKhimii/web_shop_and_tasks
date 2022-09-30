package model.captcha.captcha.handler;

import model.captcha.factory.handler.CaptchaHandler;
import model.captcha.factory.handler.CaptchaHiddenFormFieldHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaHiddenFormFieldHandlerTest {
    private CaptchaHandler captchaHandler;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String captcha;

    @Before
    public void beforeTest() {
        captchaHandler = new CaptchaHiddenFormFieldHandler();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        captcha = "12345";
    }

    @Test
    public void saveTest() {
        captchaHandler.save(captcha, request, response);
        Mockito.verify(request);
    }
}