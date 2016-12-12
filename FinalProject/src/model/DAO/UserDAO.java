package model.DAO;

import model.domain.User;

public interface UserDAO extends DAO<User> {
    User readByLoginAndPassword(String login,String password);
}
