package aast.restaurant.service;

import aast.restaurant.model.Item;
import aast.restaurant.model.Order;

import java.util.List;

public interface RestaurantService {

    List<Item> getMenuItems();

    List<Order> getAllOrders();

    void placeOrder(Order order);

    void addItemToMenu(Item item);

    void removeItemFromMenu(Item item);

    void markOrderAsDelivered(long orderId);

    List<Order> getAllPendingOrders();

    void updateItemPrice(long itemId, double newPrice);

}
