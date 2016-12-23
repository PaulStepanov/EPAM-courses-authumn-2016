package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.ServiceManager;
import controller.services.TicketService;

/**
 * Created by frees on 19.12.2016.
 */
public class UserControler extends Controler {
    public UserControler() {
        super();
        super.addRoute(new Route(RouteMethod.GET,
                "/user/tickets",
                (request, response) -> {
                    TicketService ticketService = (TicketService) ServiceManager.getService(TicketService.class);
//                    ticketService.
                }));
    }
}
