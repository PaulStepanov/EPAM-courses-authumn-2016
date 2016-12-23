package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Execute Controler routing functions
 * Pattern decorator
 **/
public class ControlerExecuter {
    private Controler controler;
    private RouteMethod method;

    public ControlerExecuter(Controler controler) {
        this.controler = controler;
    }

    public void initExecutor(HttpServletRequest request, HttpServletResponse response) {
        method = RouteMethod.valueOf(request.getMethod());
        HashMap<RouteMethod,HashMap> routings=controler.getRoutings();
        HashMap<String,Route> routMap=routings.get(
                RouteMethod.valueOf(request.getMethod()));
        routMap.forEach((uri, route) -> {
            if (route.getURI().equals(request.getPathInfo())) {// TODO написать функцию обрабатывающую URL и ошибкт
                    route.getRoutingFunction().exec(request, response);
            }
        });
    }

}
