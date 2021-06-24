package aast.restaurant;

import aast.restaurant.model.Item;
import aast.restaurant.ui.WelcomePage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantApplication extends Application {
    private final WelcomePage welcomePage = new WelcomePage();

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        readDummyItems();
        welcomePage.displayWelcomePage(stage);
        stage.show();
    }


    private static void addDummyItems() {

        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setItemId(1);
        item.setName("1/2 Grilled Chicken");
        item.setPrice(10);

        Item item2 = new Item();
        item2.setItemId(1);
        item2.setName("1/4 Grilled Chicken");
        item2.setPrice(10);

        items.add(item);
        items.add(item2);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("items.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
