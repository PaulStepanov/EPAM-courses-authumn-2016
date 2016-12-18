package controller.servlets;

import controller.controlers.ControlerExecuter;
import controller.controlers.LoginControler;
import controller.controlers.TicketsControler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by frees on 13.12.2016.
 */

public class HtmlServlet extends HttpServlet {
    private ControlerExecuter loginExec=new ControlerExecuter(new TicketsControler());
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        loginExec.initExecutor(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        loginExec.initExecutor(request,response);
    }
}
