package model.captcha.factory;

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
        JspWriter out = pageContext.getOut();
        int captchaId = Integer.parseInt(context.getAttribute("captchaId").toString());
        try {
            out.println("<img alt=\"captcha\" src=\"/captcha-servlet\">");
            out.println(" <input type=\"hidden\" id=\"hiddenCaptcha\" name=\"hiddenCaptcha\" value=\"" + captchaId + "\">");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}