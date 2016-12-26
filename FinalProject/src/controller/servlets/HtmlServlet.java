package controller.servlets;

import controller.controlers.AdminControler;
import controller.controlers.ControlerRegister;
import controller.controlers.FlightControler;
import controller.controlers.TicketsControler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by frees on 13.12.2016.
 */

public class HtmlServlet extends HttpServlet {
    private ControlerRegister controlerRegister= new ControlerRegister();

    @Override
    public void init() throws ServletException {
        super.init();
        controlerRegister.registerControler(new AdminControler());
        controlerRegister.registerControler(new FlightControler());
        controlerRegister.registerControler(new TicketsControler());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        controlerRegister.activateControlers(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        controlerRegister.activateControlers(request,response);
    }
}
