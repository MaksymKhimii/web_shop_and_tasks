package model.captcha.factory.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Timer;
import java.util.TimerTask;

/**
 * handler for saving captchaId in hidden field
 *
 * @see CaptchaHandler
 */
public class CaptchaHiddenFormFieldHandler implements CaptchaHandler {
    @Override
    public void save(String captcha, HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        context.setAttribute("captchaId", captcha);
        request.setAttribute("captchaId", captcha);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                context.removeAttribute("captchaId");
                request.removeAttribute("captchaId");
                System.out.println("the captcha was removed");
            }
        };
        timer.schedule(task, 30 * 1000);
    }

    @Override
    public String extract(HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        if (context.getAttribute("captchaId") == null) {
            return "";
        }
        return request.getParameter("captchaId");
    }
}