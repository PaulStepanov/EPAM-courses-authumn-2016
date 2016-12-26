package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.CurrentFlightService;
import controller.services.FlightService;
import controller.services.ServiceManager;
import model.domain.CurrentFlight;
import model.domain.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class FlightControler extends Controler {
    public FlightControler() {
        super();
        this.addRoute(new Route(RouteMethod.GET,
                "/flights",
                (request, response) -> {
                    RequestDispatcher flightsDispatcher = request.getServletContext().getRequestDispatcher("/flights.jsp");
                    FlightService flightService = (FlightService) ServiceManager.getService(FlightService.class);
                    ArrayList<Flight> flights = (ArrayList<Flight>) flightService.findAll();
                    request.setAttribute("flights", flights);
                    try {
                        flightsDispatcher.forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }));
        this.addRoute(new Route(RouteMethod.GET,
                "/currentFlight",
                (request, response) -> {
                    CurrentFlightService currentFlightService = (CurrentFlightService) ServiceManager.getService(CurrentFlightService.class);
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    CurrentFlight flight = currentFlightService.find(id);
                    if (flight == null) {
                        request.setAttribute("status", 404);
                        RequestDispatcher errorDispatcher = request.getServletContext().getRequestDispatcher("/error.jsp");
                        try {
                            errorDispatcher.forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        RequestDispatcher curFlightDispatcher = request.getServletContext().getRequestDispatcher("/currentFlight.jsp");
                        try {
                            request.setAttribute("currentFlight", flight);
                            curFlightDispatcher.forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }));
        this.addRoute(new Route(RouteMethod.GET,
                "/availableFlights",
                (request, response) -> {
                    CurrentFlightService currentFlightService = (CurrentFlightService) ServiceManager.getService(CurrentFlightService.class);
                    ArrayList<CurrentFlight> flights = (ArrayList<CurrentFlight>) currentFlightService.findAll();
                    request.setAttribute("currentFlights", flights);
                    RequestDispatcher curFlightsDispatcher = request.getServletContext().getRequestDispatcher("/avalibleFlights.jsp");
                    try {
                        curFlightsDispatcher.forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
