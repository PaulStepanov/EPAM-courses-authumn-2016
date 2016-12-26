package controller.servlets;

import controller.controlers.ControllerRegister;
import controller.controlers.controlersImpl.AdminController;
import controller.controlers.controlersImpl.FlightController;
import controller.controlers.controlersImpl.TicketsController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by frees on 13.12.2016.
 */

public class HtmlServlet extends HttpServlet {
    private ControllerRegister controllerRegister = new ControllerRegister();

    @Override
    public void init() throws ServletException {
        super.init();
        controllerRegister.registerController(new AdminController());
        controllerRegister.registerController(new FlightController());
        controllerRegister.registerController(new TicketsController());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        controllerRegister.activateControllers(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        controllerRegister.activateControllers(request, response);
    }
}
