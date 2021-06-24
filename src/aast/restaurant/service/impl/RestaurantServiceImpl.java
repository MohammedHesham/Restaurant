package aast.restaurant.service.impl;

import aast.restaurant.model.Item;
import aast.restaurant.model.Order;
import aast.restaurant.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    @Override
    public List<Item> getMenuItems() {

        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void placeOrder(Order order) {

    }

    @Override
    public void addItemToMenu(Item item) {

    }

    @Override
    public void removeItemFromMenu(Item item) {

    }

    @Override
    public void markOrderAsDelivered(long orderId) {

    }

    @Override
    public List<Order> getAllPendingOrders() {
        return null;
    }

    @Override
    public void updateItemPrice(long itemId, double newPrice) {

    }
}
