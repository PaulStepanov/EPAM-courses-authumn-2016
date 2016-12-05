package buildConsole;

import controller.services.TicketServiceImpl;
import model.db.ConnectionManagerMySQLDriver;

public class ConsoleView {
    public static void showAllTickets() {
        new TicketServiceImpl(new ConnectionManagerMySQLDriver())
                .findAll().forEach(ticket -> {
            System.out.println("TicketID: " + ticket.getId());
            System.out.println("TicketCost: " + ticket.getFlightCost());
            System.out.println("Client: " + ticket.getClient().getName());
            System.out.println("Flight: " + ticket.getCurrentFlight().getFlight().getName());
            System.out.println("Lagage capacity: " + ticket.getLagageCapacity());
            System.out.println("-----------------");
        });

    }
}
