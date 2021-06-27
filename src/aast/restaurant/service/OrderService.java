package aast.restaurant.service;

import aast.restaurant.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    List<Order> getAllPendingOrders();

    void placeOrder(Order order);

    void markOrderAsDelivered(long orderId);
}
