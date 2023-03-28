package com.example.loginfx.error;

import javafx.scene.control.Alert;

public abstract class PhoneNumberErrorPrinter {

    public static void displayPhoneNumberHasLetterError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Phone number cannot contain letters!");
        alert.show();
    }

    public static void displayPhoneNumberMustBe11CharsLongError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Phone number must be 11 numbers long!");
        alert.show();
    }

    public static void displayPhoneNumberMustStartWith09Error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Phone number must start with 09!");
        alert.show();
    }

}
