package model.service;

import model.captcha.factory.handler.CaptchaAttributeHandler;
import model.captcha.factory.handler.CaptchaHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaServiceTest {
    private CaptchaService captchaService;
    private ServletContext context;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CaptchaHandler captchaHandler;

    @Before
    public void beforeTest() {
        context = Mockito.mock(ServletContext.class);
        captchaService = new CaptchaService(context);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        captchaHandler = Mockito.mock(CaptchaAttributeHandler.class);
    }

    @Test
    public void generateCaptchaTest() {
        Mockito.when(context.getAttribute("captchaHandler")).thenReturn(captchaHandler);
        int actualCaptchaId = captchaService.generateCaptcha(request, response);
        Mockito.verify(context);
        Assert.assertTrue(actualCaptchaId >= 0 && actualCaptchaId <= 9);
    }
}