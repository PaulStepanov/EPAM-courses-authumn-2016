package model.domain;

import org.joda.time.Duration;

public class Flight extends Entity {
    private String name;
    private City arrivalCity;
    private City departureCity;
    private Duration flightTime;
    private Integer maxLagage;

    public Flight(String name, City arrivalCity, City departureCity, Duration flightTime, Integer maxLagage) {
        this.name = name;
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
        this.flightTime = flightTime;
        this.maxLagage = maxLagage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public Duration getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Duration flightTime) {
        this.flightTime = flightTime;
    }

    public Integer getMaxLagage() {
        return maxLagage;
    }

    public void setMaxLagage(Integer maxLagage) {
        this.maxLagage = maxLagage;
    }
}
