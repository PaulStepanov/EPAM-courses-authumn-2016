package controller.controlers.controlersImpl;

import controller.controlers.Controller;
import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.ServiceManager;
import controller.services.TicketService;
import model.domain.Ticket;
import model.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TicketsController extends Controller {
    public TicketsController() {
        super();
        super.addRoute(new Route(RouteMethod.GET,
                "/user/tickets",
                (request, response) -> {
                    User user = (User) request.getSession().getAttribute("user");
                    TicketService ticketService = (TicketService) ServiceManager.getService(TicketService.class);
                    ArrayList<Ticket> tickets = (ArrayList<Ticket>) ticketService.findByUser(user.getId());
                    request.setAttribute("tickets", tickets);
                    RequestDispatcher tictesDispatcher = request.getServletContext().getRequestDispatcher("/myTickets.jsp");
                    try {
                        tictesDispatcher.forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }

                }));
        super.addRoute(new Route(RouteMethod.POST,
                "/user/buyTicket",
                (request, response) -> {
                    Integer flightID = Integer.valueOf(request.getParameter("FlightId"));
                    Integer luggage = Integer.valueOf(request.getParameter("luggage"));
                    String vip = request.getParameter("vip");
                    vip = vip == null ? "off" : "on";
                    User user = (User) request.getSession().getAttribute("user");
                    TicketService ticketService = (TicketService) ServiceManager.getService(TicketService.class);
                    boolean registred = ticketService.registerTicket(flightID, luggage,
                            vip.equals("on"),
                            user.getId());
                    try {
                        PrintWriter pw = response.getWriter();
                        if (registred) {
                            pw.write("fine");
                        }
                        pw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
