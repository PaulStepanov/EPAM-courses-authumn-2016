package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;

import java.util.HashMap;

public abstract class Controler {
    HashMap<RouteMethod,HashMap> routings=new HashMap<>();

    public Controler() {
        routings.put(RouteMethod.GET,new HashMap<String,Route>());
        routings.put(RouteMethod.POST,new HashMap<String,Route>());
        routings.put(RouteMethod.UPDATE,new HashMap<String,Route>());
        routings.put(RouteMethod.DELETE,new HashMap<String,Route>());
        routings.put(RouteMethod.ALL,new HashMap<String,Route>());
    }

    public void setRoutings(HashMap<RouteMethod, HashMap> routings) {
        this.routings = routings;
    }

    public void addRoute(Route route) {
        HashMap<String,Route> routMap=routings.get(route.getMethod());
        routMap.put(route.getURI(),route);
    }

    public  HashMap<RouteMethod,HashMap> getRoutings() {
        return routings;
    }
}
