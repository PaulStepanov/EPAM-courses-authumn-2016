package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.TicketService;
import controller.services.TicketServiceImpl;
import model.db.ConnectionPoolManager;
import model.domain.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminControler extends Controler {
    public AdminControler() {
        super();
        this.addRoute(new Route(RouteMethod.GET,
                "/admin/ticketsAll",
                (request, response) -> {
                    RequestDispatcher ticketsDispatcher = request.getServletContext().getRequestDispatcher("/ticketsAll.jsp");
                    TicketService ticketService = new TicketServiceImpl(new ConnectionPoolManager());
                    ArrayList<Ticket> tickets = (ArrayList<Ticket>) ticketService.findAll();
                    request.setAttribute("tickets", tickets);
                    try {
                        ticketsDispatcher.forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
