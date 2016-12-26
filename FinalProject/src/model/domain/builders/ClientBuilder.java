package model.domain.builders;

import model.domain.Client;
import model.domain.User;

public class ClientBuilder {
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private User user;

    public ClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ClientBuilder setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public ClientBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClientBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public Client createClient() {
        return new Client(name, surname, patronymic, phone, user);
    }
}