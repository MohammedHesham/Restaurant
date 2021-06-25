package aast.restaurant.service;

import aast.restaurant.model.Admin;

public interface AdminService {
    Admin login(String username,String password);
}
