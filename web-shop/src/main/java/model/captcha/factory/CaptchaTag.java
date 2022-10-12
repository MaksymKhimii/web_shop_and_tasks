package model.captcha.factory;

import controller.command.CaptchaServlet;
import model.captcha.factory.handler.CaptchaHandler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * in this class, a custom tag is generated
 * to display captcha images and captchaId in a hidden field
 *
 * @see CaptchaHandler
 * @see CaptchaServlet
 */
public class CaptchaTag extends TagSupport {
    @Override
    public int doStartTag() {
        ServletContext context = pageContext.getServletContext();
        JspWriter out = pageContext.getOut();
        String captchaId;
        if (context.getInitParameter("captchaHandler").equals("hiddenFormField")) {
            captchaId = (String) context.getAttribute("captchaId");
            try {
                out.println("<input type=\"hidden\" id=\"captchaId\" name=\"captchaId\" value=\"" + captchaId + "\">");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            out.println("<img alt=\"captcha\" src=\"/captcha-servlet\">");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}