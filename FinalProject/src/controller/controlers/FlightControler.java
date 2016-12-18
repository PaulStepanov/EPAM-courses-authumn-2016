package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.FlightServiceImp;
import model.db.ConnectionPoolManager;
import model.domain.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class FlightControler extends Controler{
    public FlightControler() {
        super();
        this.addRoute(new Route(RouteMethod.GET,
                "/flights",
                (request, response) -> {
                    RequestDispatcher flightsDispatcher = request.getServletContext().getRequestDispatcher("/flights.jsp");
                    FlightServiceImp flightServiceImp= new FlightServiceImp(new ConnectionPoolManager());
                    ArrayList<Flight> flights = (ArrayList<Flight>) flightServiceImp.findAll();
                    request.setAttribute("flights", flights);
                    try {
                        flightsDispatcher.forward(request,response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
