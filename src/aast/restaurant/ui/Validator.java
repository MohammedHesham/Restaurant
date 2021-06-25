package aast.restaurant.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aast.restaurant.errors.RegistrationError.FORM_ERROR;

public class Validator {

    public static boolean validateField(GridPane gridPane, TextField textField, String errorMsg) {
        if (textField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), FORM_ERROR, errorMsg);
            return false;
        }
        return true;
    }

    public static boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
