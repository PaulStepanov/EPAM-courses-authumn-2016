package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Controller is a component that contains routing map
 * keys in routing map is method,value is list of routes,that than uses in ControlerExecutor
 */
public abstract class Controller {
    private HashMap<RouteMethod, ArrayList<Route>> routings = new HashMap<>();

    public Controller() {
        routings.put(RouteMethod.GET, new ArrayList<Route>());
        routings.put(RouteMethod.POST, new ArrayList<Route>());
        routings.put(RouteMethod.UPDATE, new ArrayList<Route>());
        routings.put(RouteMethod.DELETE, new ArrayList<Route>());
        routings.put(RouteMethod.ALL, new ArrayList<Route>());
    }

    public void addRoute(Route route) {
        ArrayList<Route> routList = routings.get(route.getMethod());
        routList.add(route);
    }

    HashMap<RouteMethod, ArrayList<Route>> getRoutings() {
        return routings;
    }
}
