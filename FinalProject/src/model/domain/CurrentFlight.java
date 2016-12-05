package model.domain;

import org.joda.time.DateTime;

public class CurrentFlight extends Entity {
    private Integer Ticket_cost;
    private DateTime dateTime;
    private Integer lagageCost;
    private Flight flight;

    public Integer getTicket_cost() {
        return Ticket_cost;
    }

    public void setTicket_cost(Integer ticket_cost) {
        Ticket_cost = ticket_cost;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getLagageCost() {
        return lagageCost;
    }

    public void setLagageCost(Integer lagageCost) {
        this.lagageCost = lagageCost;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
