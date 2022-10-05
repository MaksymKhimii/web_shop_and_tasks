package model.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CaptchaServiceTest {
    private CaptchaService captchaService;

    @Before
    public void beforeTest() {
        captchaService = new CaptchaService();
    }

    @Test
    public void getCaptchaIdTest() {
        Assert.assertEquals(0, captchaService.getCaptchaId());
    }

    @Test
    public void sizeOfGeneratedCaptchaTest() {
        Assert.assertEquals(0, captchaService.getCaptcha().size());
        int id = captchaService.generateCaptcha();
        String captcha = captchaService.getCaptchaValue(id);
        Assert.assertTrue(id >= 0 && id < 10 && captcha.length() == 5);
    }
}