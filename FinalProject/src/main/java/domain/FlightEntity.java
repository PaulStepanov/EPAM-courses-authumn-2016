package domain;

import org.joda.time.Duration;

/**
 * Created by Павел on 28-Nov-16.
 */
public class FlightEntity extends Entity<String> {
    private String name;
    private City arrivalCity;
    private City departureCity;
    private Duration flightTime;
    private Integer maxLagage;

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
