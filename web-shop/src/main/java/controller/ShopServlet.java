package controller;

import controller.command.SignUpCommand;
import controller.pages.SignUpPage;
import model.service.UserService;
import model.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * main servlet of the web-shop module
 */
@WebServlet("/index")
public class ShopServlet extends HttpServlet {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * here will be commands according to my tasks
     */
    public void init(ServletConfig servletConfig) {
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        //repositories
        UserRepository userRepository = new UserRepository();
        //services
        UserService userService = new UserService(userRepository);
        //commands
        commands.put("signUpPage", new SignUpPage());
        commands.put("signUpCommand", new SignUpCommand(userService));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/", "");
        Command command = commands.getOrDefault(path, (r) -> "index.jsp");
        String page = command.execute(request);
        if (page.contains("redirect:") || page.contains("logout")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
