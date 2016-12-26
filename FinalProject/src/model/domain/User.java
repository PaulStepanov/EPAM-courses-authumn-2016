package model.domain;

public class User extends Entity {
    private String login;
    private String password;
    private String email;
    private Integer priviligesLvl = 0;

    public User(String login, String password, String email, Integer priviligesLvl) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.priviligesLvl = priviligesLvl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPriviligesLvl() {
        return priviligesLvl;
    }

    public void setPriviligesLvl(Integer priviligesLvl) {
        this.priviligesLvl = priviligesLvl;
    }
}
