package aast.restaurant.ui;

import aast.restaurant.util.ImageUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class WelcomePage {
    private final RegistrationForm registrationForm = new RegistrationForm();
    private final LoginForm loginForm = new LoginForm();

    public void displayWelcomePage(Stage stage) {
        VBox vBox = new VBox(10);

        ImageView icon = ImageUtil.getIcon();
        vBox.getChildren().add(icon);

        Button signUp = new Button("Sign up");
        signUp.setPrefWidth(200);
        Button login = new Button("Login");
        login.setPrefWidth(200);

        vBox.getChildren().addAll(signUp, login);

        signUp.setOnAction(actionEvent -> displaySignupForm(stage));

        login.setOnAction(actionEvent -> {
            displayLoginForm(stage);
        });
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(
                new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(vBox, 550, 400);
        stage.setScene(scene);
    }

    private void displaySignupForm(Stage stage) {
        GridPane registrationFormPane = registrationForm.createRegistrationFormPane();

        stage.getScene().setRoot(registrationFormPane);
    }

    private void displayLoginForm(Stage stage) {
        GridPane loginFormPane = loginForm.createLoginFormPane(stage);
        stage.getScene().setRoot(loginFormPane);
    }
}
