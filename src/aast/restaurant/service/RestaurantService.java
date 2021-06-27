package aast.restaurant.service;

import aast.restaurant.model.Item;
import aast.restaurant.model.Order;

import java.util.List;

public interface RestaurantService {

    List<Item> getMenuItems();
    void addItemToMenu(Item item);

    void removeItemFromMenu(Item item);

    void updateItemPrice(long itemId, double newPrice);

}
