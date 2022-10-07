package model.model.captcha.factory;

import model.captcha.factory.CaptchaHandlerFactory;
import model.captcha.factory.handler.CaptchaAttributeHandler;
import model.captcha.factory.handler.CaptchaCookieHandler;
import model.captcha.factory.handler.CaptchaHandler;
import model.captcha.factory.handler.CaptchaHiddenFormFieldHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class CaptchaHandlerFactoryTest {
    private CaptchaHandler captchaHandlerExpected;
    private CaptchaHandlerFactory captchaHandlerFactory;
    private ServletConfig servletConfig;
    private ServletContext context;

    @Before
    public void beforeTest() {
        captchaHandlerFactory = new CaptchaHandlerFactory();
        servletConfig = Mockito.mock(ServletConfig.class);
        context = Mockito.mock(ServletContext.class);
    }

    @Test
    public void shouldCreateCaptchaAttributeHandler() {
        Mockito.when(servletConfig.getServletContext()).thenReturn(context);
        Mockito.when(context.getInitParameter("captchaHandler")).thenReturn("attribute");
        captchaHandlerExpected = new CaptchaAttributeHandler();
        Assert.assertEquals(captchaHandlerExpected.getClass(), captchaHandlerFactory.create("attribute").getClass());
    }

    @Test
    public void shouldCreateCaptchaCookieHandler() {
        Mockito.when(servletConfig.getServletContext()).thenReturn(context);
        Mockito.when(context.getInitParameter("captchaHandler")).thenReturn("cookie");
        captchaHandlerExpected = new CaptchaCookieHandler();
        Assert.assertEquals(captchaHandlerExpected.getClass(), captchaHandlerFactory.create("cookie").getClass());
    }

    @Test
    public void shouldCreateCaptchaHiddenFormFieldHandler() {
        Mockito.when(servletConfig.getServletContext()).thenReturn(context);
        Mockito.when(context.getInitParameter("captchaHandler")).thenReturn("hiddenField");
        captchaHandlerExpected = new CaptchaHiddenFormFieldHandler();
        Assert.assertEquals(captchaHandlerExpected.getClass(), captchaHandlerFactory.create("hiddenFormField").getClass());
    }
}