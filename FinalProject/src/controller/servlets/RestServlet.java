package controller.servlets;

import controller.controlers.ControlerRegister;
import controller.controlers.LoginControler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestServlet extends HttpServlet {
    private ControlerRegister controlerRegister= new ControlerRegister();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        controlerRegister.registerControler(new LoginControler());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        controlerRegister.activateControlers(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        controlerRegister.activateControlers(request,response);
    }
}
