package model.domain;

public class Ticket extends Entity {
    private Integer flightCost;
    private Client client;
    private Integer lagageCapacity;
    private Boolean vip = false;
    private CurrentFlight currentFlight;

    public Integer getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(Integer flightCost) {
        this.flightCost = flightCost;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getLagageCapacity() {
        return lagageCapacity;
    }

    public void setLagageCapacity(Integer lagageCapacity) {
        this.lagageCapacity = lagageCapacity;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public CurrentFlight getCurrentFlight() {
        return currentFlight;
    }

    public void setCurrentFlight(CurrentFlight currentFlight) {
        this.currentFlight = currentFlight;
    }
}
