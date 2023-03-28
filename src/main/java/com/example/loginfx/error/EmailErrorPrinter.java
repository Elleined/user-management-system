package com.example.loginfx.error;

import javafx.scene.control.Alert;

public abstract class EmailErrorPrinter {

    public static void displayEmailMustEndWithGmailComError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Email must end with @gmail.com");
        alert.show();
    }

    public static void displayEmailAlreadyExistError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Email already exist!");
        alert.show();
    }

    public static void displayEmailDidNotExistError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Email didn't exist!");
        alert.show();
    }

    public static void displayEmailNotLegibleForLogin() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("This user is not legible for login!");
        alert.show();
    }
}
