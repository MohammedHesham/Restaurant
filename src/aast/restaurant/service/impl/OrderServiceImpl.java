package aast.restaurant.service.impl;

import aast.restaurant.model.Order;
import aast.restaurant.service.OrderService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private List<Order> orders = new ArrayList<>();

    public OrderServiceImpl() {
        loadOrders();
    }

    private void loadOrders() {
        try {
            File file = new File("orders.txt");
            if (!file.exists()) {
                saveAllOrders();
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            orders = (List<Order>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public List<Order> getAllPendingOrders() {
        return null;
    }

    @Override
    public void placeOrder(Order order) {

    }


    @Override
    public void markOrderAsDelivered(long orderId) {

    }


    private void saveAllOrders() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("orders.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
