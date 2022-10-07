package model.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;

public class CaptchaServiceTest {
    private CaptchaService captchaService;
    private ServletContext context;

    @Before
    public void beforeTest() {
        captchaService = new CaptchaService();
        context = Mockito.mock(ServletContext.class);
    }

    @Test
    public void generateCaptchaTest() {
        int actualCaptchaId = captchaService.generateCaptcha(context);
        Mockito.verify(context);
        Assert.assertTrue(actualCaptchaId >= 0 && actualCaptchaId <= 9);
    }
}