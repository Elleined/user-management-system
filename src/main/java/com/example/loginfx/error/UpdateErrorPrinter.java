package com.example.loginfx.error;

import javafx.scene.control.Alert;

public abstract class UpdateErrorPrinter {

    public static void displayBirthDayNotUpdatableError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("When updating birthday cannot be modified!");
        alert.show();
    }

    public static void displaySexNotUpdatableError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("When updating sex cannot be modified!");
        alert.show();
    }

    public static void displayEmailNotUpdatableError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("When Updating email cannot be modified!");
        alert.show();
    }


}
