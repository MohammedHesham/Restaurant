package aast.restaurant;

import aast.restaurant.model.Item;
import aast.restaurant.service.impl.RestaurantServiceImpl;
import aast.restaurant.ui.WelcomePage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantApplication extends Application {
    private final WelcomePage welcomePage = new WelcomePage();

    public RestaurantApplication() {
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
//        readDummyItems();
        welcomePage.displayWelcomePage(stage);
        stage.show();
    }





}
