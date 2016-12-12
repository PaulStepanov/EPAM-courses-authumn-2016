package controller.services;

import model.domain.User;

public interface UsersService {
    User getByLoginAndPassword(String login, String password);
}
