package model.domain;

public class City extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public City(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
