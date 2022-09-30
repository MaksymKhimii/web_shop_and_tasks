package model.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CaptchaServiceTest {
    private HashMap<Integer, String> captchaTest;
    private Integer expectedIdCaptchaTest;
    private HttpServletRequest request;

    @Before
    public void beforeTest() {
        expectedIdCaptchaTest = 1;
        String expectedCaptcha = "546321";
        captchaTest = new HashMap<>();
        captchaTest.put(expectedIdCaptchaTest, expectedCaptcha);
        request = Mockito.mock(HttpServletRequest.class);
    }

    @Test
    public void getCaptchaIdTest() {
        Assert.assertEquals(expectedIdCaptchaTest, CaptchaService.getCaptchaId(captchaTest));
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void deleteCaptchaTest() {
        CaptchaService.deleteCurrentCaptcha(request);
        CaptchaService.getCaptchaId(captchaTest);
    }

    @Test
    public void sizeOfGeneratedCaptchaTest() {
        captchaTest = CaptchaService.generateCaptcha();
        Assert.assertEquals(1, captchaTest.size());
        int id = CaptchaService.getCaptchaId(captchaTest);
        Assert.assertEquals(5, captchaTest.get(id).length());
    }
}