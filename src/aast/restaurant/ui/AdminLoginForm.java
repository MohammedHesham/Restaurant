package aast.restaurant.ui;

import aast.restaurant.model.Admin;
import aast.restaurant.model.User;
import aast.restaurant.service.AdminService;
import aast.restaurant.service.impl.AdminServiceImpl;
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
import javafx.stage.Stage;

import static aast.restaurant.errors.RegistrationError.*;
import static aast.restaurant.ui.Validator.*;
import static aast.restaurant.ui.Validator.showAlert;

public class AdminLoginForm {
    private final AdminService adminService;

    public AdminLoginForm() {
        adminService = new AdminServiceImpl();
    }

    public GridPane createLoginFormPane(Stage stage) {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);


        gridPane.setBackground(
                new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        addUIControls(stage, gridPane);
        return gridPane;
    }

    private void addUIControls(Stage stage, GridPane gridPane) {
        ImageView icon = ImageUtil.getIcon();
        gridPane.add(icon, 0, 0, 2, 1);
        GridPane.setHalignment(icon, HPos.CENTER);
        GridPane.setMargin(icon, new Insets(20, 0, 20, 0));

        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0, 1);

        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);


        nameField.setText("admin");
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 2);
        passwordField.setText("admin");

        Button submitButton = new Button("Confirm");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 3, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        submitButton.setOnAction(event -> {
            if (!validateField(gridPane, nameField, ENTER_NAME)) return;
            if (!validateField(gridPane, passwordField, ENTER_PASSWORD)) return;

            Admin admin = adminService.login(nameField.getText(), passwordField.getText());
            if (admin == null) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Login Failed!", "Invalid mail or password!");
                return;
            }
            AdminMainPage adminMainPage = new AdminMainPage();
            adminMainPage.displayMainPage(stage);

        });
    }
}
