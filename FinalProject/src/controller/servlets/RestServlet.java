package controller.servlets;

import controller.controlers.ControllerRegister;
import controller.controlers.controlersImpl.LoginController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestServlet extends HttpServlet {
    private ControllerRegister controllerRegister = new ControllerRegister();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        controllerRegister.registerController(new LoginController());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        controllerRegister.activateControllers(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        controllerRegister.activateControllers(request, response);
    }
}
