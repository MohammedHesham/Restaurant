package aast.restaurant;

import aast.restaurant.ui.AdminLoginForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        GridPane loginFormPane = adminLoginForm.createLoginFormPane(primaryStage);
        Scene scene = new Scene(loginFormPane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        ImageUtil.downloadImage("https://www.javacodegeeks.com/wp-content/uploads/2018/10/progressbar-dark-theme.png", "resuult.png");
    }
}
