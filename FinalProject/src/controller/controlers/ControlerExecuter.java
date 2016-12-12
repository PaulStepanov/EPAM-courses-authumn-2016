package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Execute Controler routing functions
 **/
public class ControlerExecuter {

    private Controler controler;
    private RouteMethod method;
    private ArrayList<Route> routes= new ArrayList<>();

    public ControlerExecuter(Controler controler, RouteMethod method) {
        this.controler = controler;
        this.method = method;
    }

    public void initExecutor(HttpServletRequest request, HttpServletResponse response) {
        initRoutes();
        //тут логика какой метод вызываать TODO Заменить ForEach nа forin с преррыванием
        // TODO написать функцию обрабатывающую RL
        controler.getRoutings().forEach(route -> {
            if (route.getURI().equals(request.getPathInfo())) {
                route.getRoutingFunction().exec(request,response);
            }
        });
    }

    /*in routes after initRoutes nethod will be only routes wich matches nessesary method*/
    private void initRoutes() {
        controler.getRoutings().forEach(route -> {
            if (route.getMethod()==method) {
                this.routes.add(route);
            }
        });
    }
}
