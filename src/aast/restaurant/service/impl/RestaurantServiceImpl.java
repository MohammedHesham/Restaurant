package aast.restaurant.service.impl;

import aast.restaurant.model.Item;
import aast.restaurant.model.Order;
import aast.restaurant.service.RestaurantService;
import aast.restaurant.util.ImageUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    private List<Item> items = new ArrayList<>();

    public RestaurantServiceImpl() {
        loadItems();
        if (items.isEmpty()) {
            addDummyItems();
        }
    }

    private void loadItems() {
        try {
            File file = new File("items.txt");
            if (!file.exists()) {
                saveAllItems();
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            items = (List<Item>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveAllItems() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("items.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Item> getMenuItems() {
        return items;
    }


    @Override
    public void addItemToMenu(Item item) {
        if (item.getImageUrl() != null && !item.getImageUrl().isEmpty()) {
            ImageUtil.downloadImage(item.getImageUrl(), items.size() + 1 + ".png");
        }
        items.add(item);
        saveAllItems();
    }

    @Override
    public void removeItemFromMenu(Item item) {

    }


    @Override
    public void updateItemPrice(long itemId, double newPrice) {

    }


    private void addDummyItems() {

        Item item = new Item();
        item.setItemId(1);
        item.setName("1/2 Grilled Chicken");
        item.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        item.setImageUrl("https://www.southsidemarket.com/wp-content/uploads/2017/07/smoked-chicken-halves.jpg");
        item.setPrice(10);
        addItemToMenu(item);

        Item item2 = new Item();
        item2.setItemId(1);
        item2.setName("1/4 Grilled Chicken");
        item2.setImageUrl("https://mauritius.steers.africa/images/menu/chicken/QuarterFGC.png");
        item2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        item2.setPrice(10);
        addItemToMenu(item2);
    }

    private static void readDummyItems() {
        try {
            FileInputStream fis = new FileInputStream("items.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Item> items = (List<Item>) ois.readObject();

            for (Item item : items) {
                System.err.println(item);
            }

            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        readDummyItems();
//    }
}
