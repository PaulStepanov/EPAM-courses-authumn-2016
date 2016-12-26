package model.domain.builders;

import model.domain.CurrentFlight;
import model.domain.Flight;
import org.joda.time.DateTime;

public class CurrentFlightBuilder {
    private Integer ticket_cost;
    private DateTime dateTime;
    private Integer lagageCost;
    private Flight flight;

    public CurrentFlightBuilder setTicket_cost(Integer ticket_cost) {
        this.ticket_cost = ticket_cost;
        return this;
    }

    public CurrentFlightBuilder setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public CurrentFlightBuilder setLagageCost(Integer lagageCost) {
        this.lagageCost = lagageCost;
        return this;
    }

    public CurrentFlightBuilder setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }

    public CurrentFlight createCurrentFlight() {
        return new CurrentFlight(ticket_cost, dateTime, lagageCost, flight);
    }
}