package model.DAO;

import model.domain.User;

public interface UserDAO extends DBDAO<User> {
    User readByLoginAndPassword(String login, String password);
}
