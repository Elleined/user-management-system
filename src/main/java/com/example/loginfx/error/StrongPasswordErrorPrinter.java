package com.example.loginfx.error;

import javafx.scene.control.Alert;

public abstract class StrongPasswordErrorPrinter {
    public static void displayPasswordHasSpaceError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password cannot contain space!");
        alert.show();
    }

    public static void displayPasswordMustBe8CharsLongError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password must be 8 characters long!");
        alert.show();
    }

    public static void displayPasswordHasLowerCaseLetterError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password must have at least one lowercase letter!");
        alert.show();
    }

    public static void displayPasswordHasUpperCaseLetterError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password must have at least one uppercase letter!");
        alert.show();
    }

    public static void displayPasswordHasDigitError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password must have at least one digit!");
        alert.show();
    }

    public static void displayPasswordHasSpecialCharError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password must contain at least one special character!");
        alert.show();
    }

    public static void displayPasswordDoesNotMatchError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password does not match!");
        alert.show();
    }

    public static void displayPasswordIncorrect() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Password incorrect!");
        alert.show();
    }
}
