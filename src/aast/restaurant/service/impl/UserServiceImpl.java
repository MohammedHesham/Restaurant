package aast.restaurant.service.impl;

import aast.restaurant.model.User;
import aast.restaurant.service.UserService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    public UserServiceImpl() {
        loadUsers();
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        for (User user : userService.users) {
            System.err.println(user.getUsername());
        }
    }

    @Override
    public void signup(User user) {
        users.add(user);
        saveAllUsers(users);
    }

    public boolean userExistsByMail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean userExistsByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void changePassword(User user, String newPassword) {

    }

    @Override
    public void subscribeToElite(User user) {

    }

    @Override
    public void deactivateAccount(User user) {

    }

    @Override
    public User performLogin(String mail, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(mail) && user.getPassword().equals(password))
                return user;
        }
        return null;

    }

    private void loadUsers() {
        try {
            File file = new File("users.txt");
            if (!file.exists()) {
                //initialize users file with an empty list
                List<User> users = new ArrayList<>();
                saveAllUsers(users);
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (List<User>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    private void saveAllUsers(List<User> users) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("users.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
