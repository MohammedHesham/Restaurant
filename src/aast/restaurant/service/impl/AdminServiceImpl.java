package aast.restaurant.service.impl;

import aast.restaurant.model.Admin;
import aast.restaurant.service.AdminService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private List<Admin> admins = new ArrayList<>();

    public AdminServiceImpl() {
        loadAdmins();
    }

    @Override
    public Admin login(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equalsIgnoreCase(username)
                    && admin.getPassword().equals(password))
                return admin;
        }

        return null;
    }

    private void loadAdmins() {
        try {
            File file = new File("admins.txt");
            if (!file.exists()) {
                Admin admin = new Admin();
                admin.setEmail("admin@admin.com");
                admin.setUsername("admin");
                admin.setPassword("admin");
                admins.add(admin);
                saveAllAdmins(admins);
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            admins = (List<Admin>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveAllAdmins(List<Admin> admins) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("admins.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(admins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
