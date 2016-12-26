package controller.controlers.controlersImpl;

import controller.controlers.Controller;
import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.ServiceManager;
import controller.services.TicketService;
import model.domain.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminController extends Controller {
    public AdminController() {
        super();
        this.addRoute(new Route(RouteMethod.GET,
                "/admin/ticketsAll",
                (request, response) -> {
                    RequestDispatcher ticketsDispatcher = request.getServletContext().getRequestDispatcher("/ticketsAll.jsp");
                    TicketService ticketService = (TicketService) ServiceManager.getService(TicketService.class);
                    ArrayList<Ticket> tickets = (ArrayList<Ticket>) ticketService.findAll();
                    request.setAttribute("tickets", tickets);
                    try {
                        ticketsDispatcher.forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
