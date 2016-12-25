package controller.servlets;

import controller.controlers.AdminControler;
import controller.controlers.ControlerExecuter;
import controller.controlers.FlightControler;
import controller.controlers.TicketsControler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by frees on 13.12.2016.
 */

public class HtmlServlet extends HttpServlet {
    private ControlerExecuter loginExec=new ControlerExecuter(new AdminControler());
    private ControlerExecuter flightExec=new ControlerExecuter(new FlightControler());
    private ControlerExecuter userExec=new ControlerExecuter(new TicketsControler());
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        flightExec.initExecutor(request,response);
        loginExec.initExecutor(request,response);
        userExec.initExecutor(request,response);
        //TODO page not found it's a bug
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        loginExec.initExecutor(request,response);
        userExec.initExecutor(request,response);
    }
}
