package model.captcha.captcha.handler;

import controller.pages.SignUpPage;
import model.captcha.factory.handler.CaptchaAttributeHandler;
import model.captcha.factory.handler.CaptchaHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CaptchaAttributeHandlerTest {
    private CaptchaHandler captchaHandler;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private String captcha;

    @Before
    public void beforeTest() {
        captchaHandler = new CaptchaAttributeHandler();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        captcha = "12345";
        Mockito.mockStatic(SignUpPage.class);
    }

    @Test
    public void saveTest() {
        Mockito.when(request.getSession(true)).thenReturn(session);
        captchaHandler.save(captcha, request, response);
        Mockito.verify(session);
    }

    @Test
    public void extractTest() {
        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(session.getAttribute("captcha")).thenReturn("12345");
        captchaHandler.extract(request);
        Mockito.verify(SignUpPage.class);
    }
}