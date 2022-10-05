/*
package controller.command;

import model.captcha.CaptchaSignUp;
import model.captcha.factory.handler.CaptchaHandler;
import model.entity.User;
import model.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.when;

public class SignUpCommandTest {
    //private SignUpCommand signUpCommand;
    private HttpServletRequest request;
    private String successPath;
    private String errorPath;
    private User newUser;
    private CaptchaHandler captchaHandler;
    private UserService userService;

    public SignUpCommandTest() {
    }

    @Test
    public void beforeTest() {
        successPath = "/WEB-INF/user/afterValidPage.jsp";
        errorPath = "/WEB-INF/common/errorPage.jsp";
        userService = Mockito.mock(UserService.class);
        signUpCommand = new SignUpCommand(userService);
        request = Mockito.mock(HttpServletRequest.class);
        newUser = new User("agent008", "Mark", "Samons", "12345", "markSamons@gmail.com");
        Mockito.mockStatic(CaptchaSignUp.class);
        captchaHandler = Mockito.mock(CaptchaHandler.class);
    }

    @Test
    public void executeSuccessTest() {
        try (MockedStatic<CaptchaSignUp> mockedStatic = Mockito.mockStatic(CaptchaSignUp.class)) {
            mockedStatic.when(CaptchaSignUp::getCaptchaHandler).thenReturn(captchaHandler);
        }
        Mockito.when(captchaHandler.extract(request)).thenReturn("12345");
        Mockito.when(request.getParameter("username")).thenReturn(newUser.getLogin());
        Mockito.when(request.getParameter("firstName")).thenReturn(newUser.getFirstName());
        Mockito.when(request.getParameter("lastName")).thenReturn(newUser.getLastName());
        Mockito.when(request.getParameter("email")).thenReturn(newUser.getEmail());
        Mockito.when(request.getParameter("password")).thenReturn(newUser.getPassword());
        Mockito.when(request.getParameter("captcha")).thenReturn("12345");
        when(userService.checkUser(newUser)).thenReturn(true);
        Assert.assertEquals(successPath, signUpCommand.execute(request));
    }

    @Test
    public void executeErrorTest() {
        try (MockedStatic<CaptchaSignUp> mockedStatic = Mockito.mockStatic(CaptchaSignUp.class)) {
            mockedStatic.when(CaptchaSignUp::getCaptchaHandler).thenReturn(captchaHandler);
        }
        Mockito.when(captchaHandler.extract(request)).thenReturn("54321");
        Mockito.when(request.getParameter("username")).thenReturn(newUser.getLogin());
        Mockito.when(request.getParameter("firstName")).thenReturn(newUser.getFirstName());
        Mockito.when(request.getParameter("lastName")).thenReturn(newUser.getLastName());
        Mockito.when(request.getParameter("email")).thenReturn(newUser.getEmail());
        Mockito.when(request.getParameter("password")).thenReturn(newUser.getPassword());
        Mockito.when(request.getParameter("captcha")).thenReturn("54321");
        when(userService.checkUser(newUser)).thenReturn(false);
        Assert.assertEquals(errorPath, signUpCommand.execute(request));
    }
}*/
