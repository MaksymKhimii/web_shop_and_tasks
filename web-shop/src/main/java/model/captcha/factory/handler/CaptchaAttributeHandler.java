package model.captcha.factory.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

/**
 * handler for saving captchaId in session
 *
 * @see CaptchaHandler
 */
public class CaptchaAttributeHandler implements CaptchaHandler {
    @Override
    public void save(String captchaId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("captchaId", captchaId);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                session.setAttribute("captchaId", "1");
                System.out.println("the captcha was removed");
            }
        };
        timer.schedule(task, 30 * 1000);
    }

    @Override
    public String extract(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return session.getAttribute("captchaId").toString();
    }
}