package aast.restaurant.ui;

import aast.restaurant.model.User;
import aast.restaurant.service.UserService;
import aast.restaurant.service.impl.UserServiceImpl;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static aast.restaurant.errors.RegistrationError.*;
import static aast.restaurant.ui.Validator.*;

public class LoginForm {
    private final UserService userService;

    public LoginForm() {
        userService = new UserServiceImpl();
    }

    GridPane createLoginFormPane() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);


        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        addUIControls(gridPane);
        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Welcome to our restaurant");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label mailLabel = new Label("Email : ");
        gridPane.add(mailLabel, 0, 1);

        TextField mailField = new TextField();
        mailField.setPrefHeight(40);
        gridPane.add(mailField, 1, 1);


        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 2);

        Button submitButton = new Button("Confirm");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 3, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        submitButton.setOnAction(event -> {
            if (!validateField(gridPane, passwordField, ENTER_MAIL)) return;
            if (!isValidEmailAddress(mailField.getText())) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), FORM_ERROR, INVALID_MAIL);
                return;
            }
            User user = userService.performLogin(mailField.getText(), passwordField.getText());
            if (user == null) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Login Failed!", "Invalid mail or password!");
                return;
            }
            showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Successful!", "Welcome " + mailField.getText());

        });
    }
}
