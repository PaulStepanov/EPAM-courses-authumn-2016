package controller.servlets;

import controller.controlers.ControlerExecuter;
import controller.controlers.LoginControler;
import controller.controlers.routes.RouteMethod;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*TODO пофиксить костыль с сервлетом,ибо если оставить /то ресурсы из web папки не получаются,
также*/
//@WebServlet("/*")
public class RestServlet extends HttpServlet {
    private ControlerExecuter loginExec=new ControlerExecuter(new LoginControler());
    /*Testing*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        loginExec.initExecutor(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        loginExec.initExecutor(request,response);
    }
}
