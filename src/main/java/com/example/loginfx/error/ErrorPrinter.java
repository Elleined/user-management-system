package com.example.loginfx.error;

import javafx.scene.control.Alert;

public abstract class ErrorPrinter {

    public static void displayEmptyFieldError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("This field cannot be empty!");
        alert.show();
    }

    public static void displayFieldHasDigitError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Field cannot contain digit!");
        alert.show();
    }

    public static void displayFieldHasLetterError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("This field cannot contain letter!");
        alert.show();
    }

    public static void displayIDoesNotExistError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Id didn't exist!");
        alert.show();
    }

    public static void displayIdAndEmailNotMatchError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Id and email must come from the same record!");
        alert.show();
    }
}
