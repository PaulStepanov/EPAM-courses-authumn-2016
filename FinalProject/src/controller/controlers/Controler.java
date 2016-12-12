package controller.controlers;

import controller.controlers.routes.Route;

import java.util.ArrayList;

public abstract class Controler {
    ArrayList<Route> routings=new ArrayList<>();

    public void addRoute(Route route) {
        routings.add(route);
    }

    public ArrayList<Route> getRoutings() {
        return routings;
    }
}
