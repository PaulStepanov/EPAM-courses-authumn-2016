package model.domain;

public class UserBuilder {
    private String login;
    private String password;
    private String email;
    private Integer priviligesLvl;

    public UserBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPriviligesLvl(Integer priviligesLvl) {
        this.priviligesLvl = priviligesLvl;
        return this;
    }

    public User createUser() {
        return new User(login, password, email, priviligesLvl);
    }
}