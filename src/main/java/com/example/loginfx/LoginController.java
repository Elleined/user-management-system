package com.example.loginfx;

import com.example.loginfx.error.EmailErrorPrinter;
import com.example.loginfx.error.ErrorPrinter;
import com.example.loginfx.error.StrongPasswordErrorPrinter;
import com.example.loginfx.service.LoginService;
import com.example.loginfx.service.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private final LoginService loginService = new LoginServiceImpl();
    public Button btnRegister;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUsername;

    @FXML
    public void btnRegisterPressed(ActionEvent ignoredActionEvent) throws IOException {
        Parent registerFxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        stage.setTitle("Signup Form");
        stage.setScene(new Scene(registerFxml));
    }

    @FXML
    void btnOkPressed(ActionEvent ignoredEvent) throws IOException {
        String email = tfUsername.getText().strip();
        if (loginService.isEmpty( email )) {
            ErrorPrinter.displayEmptyFieldError();
            tfUsername.requestFocus();
            return;
        }
        if (loginService.isEmailValid( email )) {
            EmailErrorPrinter.displayEmailMustEndWithGmailComError();
            tfUsername.requestFocus();
            return;
        }
        if (!loginService.isEmailExist( email )) {
            EmailErrorPrinter.displayEmailDidNotExistError();
            tfUsername.requestFocus();
            return;
        }
        if (loginService.isEmailLegibleForLogin( email )) {
            EmailErrorPrinter.displayEmailNotLegibleForLogin();
            tfUsername.requestFocus();
            return;
        }

        String password = tfPassword.getText();
        if (loginService.isEmpty( password )) {
            ErrorPrinter.displayEmptyFieldError();
            tfPassword.requestFocus();
            return;
        }

        String fetchPassword = loginService.callPasswordGetter( email ).orElseThrow();
        if (!loginService.isPasswordCorrect(password, fetchPassword)) {
            StrongPasswordErrorPrinter.displayPasswordIncorrect();
            tfPassword.requestFocus();
            return;
        }
        gotoDashBoardScene();
    }

    private void gotoDashBoardScene() throws IOException {
        Parent dashboardFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        stage.setTitle("Welcome to Dashboard");
        stage.setScene(new Scene(dashboardFXML));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Login Successfully");
        alert.show();
    }
}
