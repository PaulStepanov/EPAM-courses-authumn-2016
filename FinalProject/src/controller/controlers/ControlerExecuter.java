package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import model.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Execute Controler routing functions
 * Pattern decorator
 **/
public class ControlerExecuter {
//TODO перенести проверку привелегий в роуту
    private Controler controler;
    private RouteMethod method;
    private ArrayList<Route> routes = new ArrayList<>();
    private Integer privilegeLvl=-1;//not logged

    public ControlerExecuter(Controler controler) {
        this.controler = controler;
    }

    public void initExecutor(HttpServletRequest request, HttpServletResponse response) {
        method = RouteMethod.valueOf(request.getMethod());
        HashMap<RouteMethod,HashMap> routings=controler.getRoutings();
        HashMap<String,Route> routMap=routings.get(
                RouteMethod.valueOf(request.getMethod()));
        routMap.forEach((uri, route) -> {
            if (route.getURI().equals(request.getPathInfo())) {// TODO написать функцию обрабатывающую URL
                if (checkPrivilegeLvl((User) request.getSession().getAttribute("user"))) {
                    route.getRoutingFunction().exec(request, response);
                } else {
                    RequestDispatcher errorDispatcher = request.getServletContext().getRequestDispatcher("/error.jsp");
                    try {
                        errorDispatcher.forward(request,response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public  void setPrivilegeLvl(Integer privilegeLvl) {
        this.privilegeLvl=privilegeLvl;
    }
    private boolean checkPrivilegeLvl(User user){
        if (user==null && privilegeLvl==-1) {
            return true;
        }
        if (user.getPriviligesLvl()>=privilegeLvl) {
            return true;
        } else {
            return false;
        }
    }
}
