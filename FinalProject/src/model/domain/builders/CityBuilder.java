package model.domain.builders;

import model.domain.City;

public class CityBuilder {
    private String name;

    public CityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public City createCity() {
        return new City(name);
    }
}