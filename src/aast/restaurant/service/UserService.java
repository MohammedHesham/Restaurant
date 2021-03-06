package aast.restaurant.service;

import aast.restaurant.model.User;

import java.util.List;

public interface UserService {

    void signup(User user);

    void changePassword(User user, String newPassword);

    void subscribeToElite(User user);

    void deactivateAccount(User user);

    User performLogin(String mail, String password);

    List<User> getAllUsers();
}
