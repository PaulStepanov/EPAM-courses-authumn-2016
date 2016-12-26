package model.domain.builders;

import model.domain.City;
import model.domain.Flight;
import org.joda.time.Duration;

public class FlightBuilder {
    private String name;
    private City arrivalCity;
    private City departureCity;
    private Duration flightTime;
    private Integer maxLagage;

    public FlightBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FlightBuilder setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
        return this;
    }

    public FlightBuilder setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
        return this;
    }

    public FlightBuilder setFlightTime(Duration flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public FlightBuilder setMaxLagage(Integer maxLagage) {
        this.maxLagage = maxLagage;
        return this;
    }

    public Flight createFlight() {
        return new Flight(name, arrivalCity, departureCity, flightTime, maxLagage);
    }
}