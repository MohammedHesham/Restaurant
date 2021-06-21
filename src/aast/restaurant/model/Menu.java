package aast.restaurant.model;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private List<Item> items;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
