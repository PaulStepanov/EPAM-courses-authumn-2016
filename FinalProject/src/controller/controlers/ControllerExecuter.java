package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Execute routing functions in Controller
 **/
class ControllerExecuter {
    private Controller controller;
    private RouteMethod method;

    ControllerExecuter(Controller controller) {
        this.controller = controller;
    }

    void initExecutor(HttpServletRequest request, HttpServletResponse response) {
        method = RouteMethod.valueOf(request.getMethod());
        HashMap<RouteMethod, ArrayList<Route>> routings = controller.getRoutings();
        ArrayList<Route> routList = routings.get(
                RouteMethod.valueOf(request.getMethod()));
        routList.forEach((route) -> {
            if (route.getURI().equals(request.getPathInfo())) {
                route.getRoutingFunction().exec(request, response);
            }
        });
    }
}
