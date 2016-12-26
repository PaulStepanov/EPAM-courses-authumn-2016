package model.domain.builders;

import model.domain.User;

/**
 * Created by frees on 19.12.2016.
 */
public class UserBuilder {
    private String login;
    private String password;
    private String email;
    private Integer priviligesLvl = 0;
    private User user = new User();

    public UserBuilder(String login, String password, String email, Integer priviligesLvl, User user) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.priviligesLvl = priviligesLvl;
        this.user = user;
    }

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

    public UserBuilder setUser(User user) {
        this.user = user;
        return this;
    }
}
