package model.captcha.factory;


import model.service.CaptchaService;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * in this class, a custom tag is generated
 * to display captcha images and captchaId in a hidden field
 *
 * @see model.captcha.CaptchaSignUp
 */
public class CaptchaTag extends TagSupport {
    @Override
    public int doStartTag() {
        ServletContext context = pageContext.getServletContext();
        CaptchaService captchaService = (CaptchaService) context.getAttribute("CaptchaService");
        JspWriter out = pageContext.getOut();
        int captchaId = captchaService.getCaptchaId();
        try {
            out.println("<img alt=\"captcha\" src=\"/captcha-servlet\">");
            out.println(" <input type=\"hidden\" id=\"hiddenCaptcha\" name=\"hiddenCaptcha\" value=\"" + captchaId + "\">");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}