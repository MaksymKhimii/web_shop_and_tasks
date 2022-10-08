package controller.command;

import model.captcha.factory.CaptchaHandlerFactory;
import model.captcha.factory.handler.CaptchaHandler;
import model.service.CaptchaService;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * in this class, a captcha image is generated
 * and the method for saving this captcha is called
 *
 * @see CaptchaHandler
 * @see CaptchaHandlerFactory
 */
@WebServlet("/captcha-servlet")
public class CaptchaServlet extends HttpServlet {

    public static final String FILE_TYPE = "jpeg";
    private CaptchaService captchaService;
    private CaptchaHandler captchaHandler;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        captchaService = (CaptchaService) context.getAttribute("captchaService");
        captchaHandler = (CaptchaHandler) context.getAttribute("captchaHandler");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Progma", "no-cache");
        String captchaId = captchaHandler.extract(request);
        String captcha = captchaService.getCaptchaValue(Integer.parseInt(captchaId));
        int width = 160;
        int height = 35;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.OPAQUE);
        Graphics graphics = bufferedImage.createGraphics();
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.setColor(new Color(169, 169, 169));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(new Color(255, 255, 255));
        graphics.drawString(captcha, 20, 25);
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(bufferedImage, FILE_TYPE, outputStream);
        outputStream.close();
    }
}