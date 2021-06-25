package aast.restaurant.ui;

import aast.restaurant.model.User;
import aast.restaurant.service.impl.UserServiceImpl;
import aast.restaurant.util.ImageUtil;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aast.restaurant.errors.RegistrationError.*;
import static aast.restaurant.ui.Validator.*;

class RegistrationForm {

    private UserServiceImpl userService;

    RegistrationForm() {
        userService = new UserServiceImpl();
    }

    GridPane createRegistrationFormPane() {
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
//        Label headerLabel = new Label("Registration Form");
//        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        gridPane.add(headerLabel, 0, 0, 2, 1);
//        GridPane.setHalignment(headerLabel, HPos.CENTER);
//        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        ImageView icon = ImageUtil.getIcon();
        gridPane.add(icon, 0, 0, 2, 1);
        GridPane.setHalignment(icon, HPos.CENTER);
        GridPane.setMargin(icon, new Insets(20, 0, 20, 0));


        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0, 1);

        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);


        Label emailLabel = new Label("Email : ");
        gridPane.add(emailLabel, 0, 2);

        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);


        Label confirmPasswordLabel = new Label("Confirm Password : ");
        gridPane.add(confirmPasswordLabel, 0, 4);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPrefHeight(40);
        gridPane.add(confirmPasswordField, 1, 4);

        Button submitButton = new Button("Confirm");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        submitButton.setOnAction(event -> {

            if (!validateField(gridPane, nameField, ENTER_NAME)) return;
            if (!validateField(gridPane, emailField, ENTER_MAIL)) return;
            if (!isValidEmailAddress(emailField.getText())) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), FORM_ERROR, INVALID_MAIL);
                return;
            }

            if (userService.userExistsByMail(emailField.getText())) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), FORM_ERROR, "This email already exists!");
                return;
            }

            if (userService.userExistsByUsername(nameField.getText())) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), FORM_ERROR, "This username already exists!");
                return;
            }

            if (!validateField(gridPane, passwordField, ENTER_PASSWORD)) return;
            if (!validateField(gridPane, confirmPasswordField, CONFIRM_PASSWORD)) return;

            if (!comparePasswords(gridPane, passwordField, confirmPasswordField)) return;

            showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());

            User user = new User();
            user.setActive(true);
            user.setEmail(emailField.getText());
            user.setPassword(passwordField.getText());
            user.setUsername(nameField.getText());
            userService.signup(user);
        });
    }


    private boolean comparePasswords(GridPane gridPane, TextField password, TextField confirm) {
        if (!password.getText().equals(confirm.getText())) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), FORM_ERROR, DIFFERENT_PASSWORD);
            return false;
        }
        return true;
    }


}
