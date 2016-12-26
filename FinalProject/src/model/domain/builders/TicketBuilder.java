package model.domain.builders;

import model.domain.Client;
import model.domain.CurrentFlight;
import model.domain.Ticket;

public class TicketBuilder {
    private Integer flightCost;
    private Client client;
    private Integer lagageCapacity;
    private Boolean vip;
    private CurrentFlight currentFlight;

    public TicketBuilder setFlightCost(Integer flightCost) {
        this.flightCost = flightCost;
        return this;
    }

    public TicketBuilder setClient(Client client) {
        this.client = client;
        return this;
    }

    public TicketBuilder setLagageCapacity(Integer lagageCapacity) {
        this.lagageCapacity = lagageCapacity;
        return this;
    }

    public TicketBuilder setVip(Boolean vip) {
        this.vip = vip;
        return this;
    }

    public TicketBuilder setCurrentFlight(CurrentFlight currentFlight) {
        this.currentFlight = currentFlight;
        return this;
    }

    public Ticket createTicket() {
        return new Ticket(flightCost, client, lagageCapacity, vip, currentFlight);
    }
}