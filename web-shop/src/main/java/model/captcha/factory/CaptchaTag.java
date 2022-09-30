package model.captcha.factory;

import controller.pages.SignUpPage;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.HashMap;

/**
 * in this class, a custom tag is generated
 * to display captcha images and captchaId in a hidden field
 * @see model.captcha.CaptchaSignUp
 */
public class CaptchaTag extends TagSupport {
    @Override
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        HashMap<Integer, String> captcha = SignUpPage.getCaptcha();
        Integer captchaId = SignUpPage.getCaptchaId(captcha);
        try {
            out.println(" <img alt=\"captcha\" src=\"/captcha-servlet\">");
            out.println(" <input type=\"hidden\" id=\"hiddenCaptcha\" name=\"hiddenCaptcha\" value=\"" + captchaId + "\">");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}