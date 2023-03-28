package com.example.loginfx;

import com.example.loginfx.error.EmailErrorPrinter;
import com.example.loginfx.error.ErrorPrinter;
import com.example.loginfx.error.PhoneNumberErrorPrinter;
import com.example.loginfx.error.StrongPasswordErrorPrinter;
import com.example.loginfx.service.RegisterService;
import com.example.loginfx.service.RegisterServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class RegisterController {
    private final RegisterService registerService = new RegisterServiceImpl();

    @FXML
    private Button btnSignIn;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;
    @FXML
    private PasswordField pfPass1;
    @FXML
    private PasswordField pfPass2;
    @FXML
    private RadioButton rbMale;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private TextField tfMiddleName;
    @FXML
    private DatePicker birthdate;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private ComboBox<String> cbProvince;
    @FXML
    private ComboBox<String> cbCity;
    @FXML
    private ComboBox<String> cbBaranggay;
    @FXML
    private TextField tfPurok;
    @FXML
    private TextField tfHouseNumber;

    @FXML
    void btnSignInPressed(ActionEvent event) throws IOException {
        String firstName = tfFirstName.getText().strip();
        if (registerService.isEmpty( firstName )) {
            ErrorPrinter.displayEmptyFieldError();
            tfFirstName.requestFocus();
            return;
        }
        if (registerService.isNameHasDigit( firstName )) {
            ErrorPrinter.displayFieldHasDigitError();
            tfFirstName.requestFocus();
            return;
        }

        String middleName = tfMiddleName.getText().strip();
        if (registerService.isEmpty( middleName )) {
            ErrorPrinter.displayFieldHasDigitError();
            tfMiddleName.requestFocus();
            return;
        }
        if (registerService.isNameHasDigit( middleName )) {
            ErrorPrinter.displayFieldHasDigitError();
            tfMiddleName.requestFocus();
            return;
        }

        String lastName = tfLastName.getText().strip();
        if (registerService.isEmpty( lastName )) {
            ErrorPrinter.displayEmptyFieldError();
            tfLastName.requestFocus();
            return;
        }
        if (registerService.isNameHasDigit( lastName )) {
            ErrorPrinter.displayFieldHasDigitError();
            tfLastName.requestFocus();
            return;
        }

        String phoneNumber = tfPhoneNumber.getText().strip();
        if (registerService.isEmpty( phoneNumber )) {
            ErrorPrinter.displayEmptyFieldError();
            tfPhoneNumber.requestFocus();
            return;
        }
        if (registerService.isFieldHasLetter( phoneNumber )) {
            ErrorPrinter.displayFieldHasLetterError();
            tfPhoneNumber.requestFocus();
            return;
        }
        if (registerService.isPhone11NumberLong(phoneNumber)) {
            PhoneNumberErrorPrinter.displayPhoneNumberMustBe11CharsLongError();
            tfPhoneNumber.requestFocus();
            return;
        }
        if (registerService.isPhoneStartWith09(phoneNumber)) {
            PhoneNumberErrorPrinter.displayPhoneNumberMustStartWith09Error();
            tfPhoneNumber.requestFocus();
            return;
        }

        LocalDate birthDay = birthdate.getValue();
        if (birthDay == null) {
            ErrorPrinter.displayEmptyFieldError();
            birthdate.requestFocus();
            return;
        }

        String sex = rbMale.isSelected() ? "MALE" : "FEMALE";

        String email = tfEmail.getText().strip();
        if (registerService.isEmpty( email )) {
            ErrorPrinter.displayEmptyFieldError();
            tfEmail.requestFocus();
            return;
        }
        if (registerService.isEmailValid( email )) {
            EmailErrorPrinter.displayEmailMustEndWithGmailComError();
            tfEmail.requestFocus();
            return;
        }
        if (registerService.isEmailExist( email )) {
            EmailErrorPrinter.displayEmailAlreadyExistError();
            tfEmail.requestFocus();
            return;
        }

        String houseNumber = tfHouseNumber.getText().strip();
        if (registerService.isEmpty( houseNumber )) {
            ErrorPrinter.displayEmptyFieldError();
            tfHouseNumber.requestFocus();
            return;
        }
        if (registerService.isFieldHasLetter( houseNumber )) {
            ErrorPrinter.displayFieldHasLetterError();
            tfHouseNumber.requestFocus();
            return;
        }

        String purokNumber = tfPurok.getText().strip();
        if (registerService.isEmpty( purokNumber )) {
            ErrorPrinter.displayEmptyFieldError();
            tfPurok.requestFocus();
            return;
        }
        if (registerService.isFieldHasLetter( purokNumber )) {
            ErrorPrinter.displayFieldHasLetterError();
            tfPurok.requestFocus();
            return;
        }

        String provinceName = cbProvince.getSelectionModel().getSelectedItem();
        int selectedProvinceId = registerService.fetchIdOfSelectedProvince( provinceName ).orElseThrow();
        if (provinceName == null) {
            ErrorPrinter.displayEmptyFieldError();
            cbProvince.requestFocus();
            return;
        }

        String cityName = cbCity.getSelectionModel().getSelectedItem();
        int selectedCityId = registerService.fetchIdOfSelectedCity(cityName, selectedProvinceId).orElseThrow();
        if (cityName == null) {
            ErrorPrinter.displayEmptyFieldError();
            cbCity.requestFocus();
            return;
        }

        String baranggayName = cbBaranggay.getSelectionModel().getSelectedItem();
        int selectedBaranggayId = registerService.fetchIdOfSelectedBaranggay(baranggayName, selectedCityId).orElseThrow();
        if (baranggayName == null) {
            ErrorPrinter.displayEmptyFieldError();
            cbBaranggay.requestFocus();
            return;
        }

        String password = pfPass1.getText();
        if (registerService.isEmpty( password )) {
            ErrorPrinter.displayEmptyFieldError();
            pfPass1.requestFocus();
            return;
        }

        if (registerService.isPassHasSpace( password )) {
            StrongPasswordErrorPrinter.displayPasswordHasSpaceError();
            pfPass1.requestFocus();
            return;
        }
        if (registerService.isPass8CharsLong( password )) {
            StrongPasswordErrorPrinter.displayPasswordMustBe8CharsLongError();
            pfPass1.requestFocus();
            return;
        }
        if (registerService.isPassHasLowerCase( password )) {
            StrongPasswordErrorPrinter.displayPasswordHasLowerCaseLetterError();
            pfPass1.requestFocus();
            return;
        }
        if (registerService.isPassHasUpperCase( password )) {
            StrongPasswordErrorPrinter.displayPasswordHasUpperCaseLetterError();
            pfPass1.requestFocus();
            return;
        }
        if (registerService.isPassHasDigit( password )) {
            StrongPasswordErrorPrinter.displayPasswordHasDigitError();
            pfPass1.requestFocus();
            return;
        }
        if (registerService.isPassContainsSpecialChar( password )) {
            StrongPasswordErrorPrinter.displayPasswordHasSpecialCharError();
            pfPass1.requestFocus();
            return;
        }

        String confirmPassword = pfPass2.getText();
        if (!registerService.isPasswordCorrect(password, confirmPassword)) {
            StrongPasswordErrorPrinter.displayPasswordDoesNotMatchError();
            return;
        }

        registerService.saveUser(
                email,
                confirmPassword,
                houseNumber,
                purokNumber,
                selectedProvinceId,
                selectedCityId,
                selectedBaranggayId,
                firstName,
                middleName,
                lastName,
                phoneNumber,
                birthDay,
                sex
        );

        goToLoginScene();
    }

    private void goToLoginScene() throws IOException  {
        Parent loginFxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage = (Stage) btnSignIn.getScene().getWindow();
        stage.setTitle("Log on to Windows");
        stage.setScene(new Scene(loginFxml));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Registered Successfully!");
        alert.show();
    }

    @FXML
    public void btnProvinceCBPressed(Event event) {
        cbProvince.getItems().setAll( registerService.fetchProvinceList() );
    }

    @FXML
    public void btnCityCBPressed(Event event) {
        String selectedProvince = cbProvince.getSelectionModel().getSelectedItem();
        int selectedProvinceId = registerService.fetchIdOfSelectedProvince( selectedProvince ).orElseThrow();

        cbCity.getItems().setAll( registerService.fetchCityList(selectedProvinceId) );
    }

    @FXML
    public void btnBaranggayCBPressed(Event event) {
        String provinceName = cbProvince.getSelectionModel().getSelectedItem();
        int selectedProvinceId = registerService.fetchIdOfSelectedProvince( provinceName ).orElseThrow();

        String selectedCity = cbCity.getSelectionModel().getSelectedItem();
        int selectedCityId = registerService.fetchIdOfSelectedCity(selectedCity, selectedProvinceId).orElseThrow();

        cbBaranggay.getItems().setAll( registerService.fetchBaranggayList(selectedCityId) );
    }
}
