package aast.restaurant.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomePage {
    private RegistrationFormApplication registrationFormApplication = new RegistrationFormApplication();

    public void displayWelcomePage(Stage stage) {
        VBox vBox = new VBox(10);
        Text welcomeText = new Text("Welcome to our restaurant");
        Button signUp = new Button("Sign up");
        signUp.setPrefWidth(200);
        Button login = new Button("Login");
        login.setPrefWidth(200);

        vBox.getChildren().addAll(welcomeText, signUp, login);

        login.setOnAction(actionEvent -> displayLoginForm(stage));

        signUp.setOnAction(actionEvent -> {
            System.err.println("SIGNUP");

        });
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 500, 300);
        stage.setScene(scene);
    }

    private void displayLoginForm(Stage stage) {
        GridPane registrationFormPane = registrationFormApplication.createRegistrationFormPane();


        stage.getScene().setRoot(registrationFormPane);
    }
}
