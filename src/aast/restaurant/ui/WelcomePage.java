package aast.restaurant.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomePage {
    private final RegistrationForm registrationForm = new RegistrationForm();
    private final LoginForm loginForm = new LoginForm();

    public void displayWelcomePage(Stage stage) {
        VBox vBox = new VBox(10);
        Text welcomeText = new Text("Welcome to our restaurant");
        Button signUp = new Button("Sign up");
        signUp.setPrefWidth(200);
        Button login = new Button("Login");
        login.setPrefWidth(200);

        vBox.getChildren().addAll(welcomeText, signUp, login);

        signUp.setOnAction(actionEvent -> displaySignupForm(stage));

        login.setOnAction(actionEvent -> {
            displayLoginForm(stage);
        });
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 500, 300);
        stage.setScene(scene);
    }

    private void displaySignupForm(Stage stage) {
        GridPane registrationFormPane = registrationForm.createRegistrationFormPane();


        stage.getScene().setRoot(registrationFormPane);
    }

    private void displayLoginForm(Stage stage) {
        GridPane loginFormPane = loginForm.createLoginFormPane();
        stage.getScene().setRoot(loginFormPane);
    }
}
