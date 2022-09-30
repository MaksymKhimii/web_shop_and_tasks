package model.captcha;

import model.captcha.factory.CaptchaFactory;
import model.captcha.factory.CaptchaHandlerFactory;
import model.captcha.factory.handler.CaptchaHandler;
import controller.pages.SignUpPage;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * in this class, a captcha image is generated
 * and the method for saving this captcha is called
 * @see CaptchaHandler
 * @see CaptchaHandlerFactory
 */
@WebServlet("/captcha-servlet")
public class CaptchaSignUp extends HttpServlet {

    public static final String FILE_TYPE = "jpeg";

    private static CaptchaHandler captchaHandler;

    public static CaptchaHandler getCaptchaHandler() {
        return captchaHandler;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Progma", "no-cache");
        response.setDateHeader("Max-Age", 0);
        HashMap<Integer, String> captchaMap = SignUpPage.getCaptcha();
        int captchaId = SignUpPage.getCaptchaId(captchaMap);
        String captcha = SignUpPage.getCaptchaValue(captchaId);
        int width = 160, height = 35;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.OPAQUE);
        Graphics graphics = bufferedImage.createGraphics();
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.setColor(new Color(169, 169, 169));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(new Color(255, 255, 255));
        graphics.drawString(captcha, 20, 25);
        CaptchaFactory captchaFactory = new CaptchaHandlerFactory();
        captchaHandler = captchaFactory.create(getServletConfig());
        captchaHandler.save(String.valueOf(captchaId), request, response);
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(bufferedImage, FILE_TYPE, outputStream);
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}