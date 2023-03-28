package com.example.loginfx;

import com.example.loginfx.error.EmailErrorPrinter;
import com.example.loginfx.error.ErrorPrinter;
import com.example.loginfx.error.PhoneNumberErrorPrinter;
import com.example.loginfx.error.UpdateErrorPrinter;
import com.example.loginfx.model.User;
import com.example.loginfx.service.DashBoardService;
import com.example.loginfx.service.DashBoardServiceImpl;
import com.example.loginfx.service.RegisterService;
import com.example.loginfx.service.RegisterServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    private final DashBoardService dashBoardService = new DashBoardServiceImpl();
    private final RegisterService registerService = new RegisterServiceImpl();

    @FXML
    private TextField tfHouseNumber;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfMiddleName;
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
    private RadioButton rbMale;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private TableColumn<User, Integer> regIdColumn;
    @FXML
    private TableColumn<User, String> firstNameColumn;
    @FXML
    private TableColumn<User, String> middleNameColumn;
    @FXML
    private TableColumn<User, String> lastNameColumn;
    @FXML
    private TableColumn<User, String> phoneNumberColumn;
    @FXML
    private TableColumn<User, String> birthDateColumn;
    @FXML
    private TableColumn<User, String> sexColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnInsert;
    @FXML
    private TableColumn<User, Integer> houseNumberColumn;
    @FXML
    private TableColumn<User, Integer> purokNumberColumn;
    @FXML
    private TableColumn<User, String> baranggayNameColumn;
    @FXML
    private TableColumn<User, String> cityNameColumn;
    @FXML
    private TableColumn<User, String> provinceNameColumn;
    @FXML
    private TextField tfId;
    @FXML
    private DatePicker birthDate;
    @FXML
    private Button btnExport;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        regIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        houseNumberColumn.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
        purokNumberColumn.setCellValueFactory(new PropertyValueFactory<>("purokNumber"));
        baranggayNameColumn.setCellValueFactory(new PropertyValueFactory<>("baranggayName"));
        cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
        provinceNameColumn.setCellValueFactory(new PropertyValueFactory<>("provinceName"));
        updateTableContent();
    }

    @FXML
    private TableView<User> tblRegistrationInfo;

    @FXML
    public void btnDeletePressed(ActionEvent actionEvent) {
        User selectedUser = tblRegistrationInfo.getSelectionModel().getSelectedItem();
        if (selectedUser == null || tfId.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Select first the user you want to delete from the table!");
            alert.show();
            return;
        }

        String email = tfEmail.getText();
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
        if (!registerService.isEmailExist( email )) {
            EmailErrorPrinter.displayEmailDidNotExistError();
            tfEmail.requestFocus();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to delete this record? ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(ButtonType.CANCEL) != ButtonType.OK) return;

        int finalId = Integer.parseInt( tfId.getText() );
        dashBoardService.delete(finalId, email);

        clearFields();

        updateTableContent();

        Alert deleteSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
        deleteSuccessAlert.setContentText("Record Deleted Successfully!");
        deleteSuccessAlert.show();
    }

    @FXML
    public void btnUpdatePressed(ActionEvent actionEvent) {
        User selectedUser = tblRegistrationInfo.getSelectionModel().getSelectedItem();
        if (selectedUser == null || tfId.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Select first the user you want to update from the table!");
            alert.show();
            return;
        }

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
            ErrorPrinter.displayEmptyFieldError();
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

        LocalDate birthDay = birthDate.getValue();
        if (!birthDay.equals( selectedUser.getBirthDay() )) {
            birthDate.setValue( selectedUser.getBirthDay() );
            UpdateErrorPrinter.displayBirthDayNotUpdatableError();
            return;
        }

        String userSex = selectedUser.getSex();
        String selectedSex = rbMale.isSelected() ? "MALE" : "FEMALE";
        if (!userSex.equals( selectedSex )) {
            selectSex( userSex );
            UpdateErrorPrinter.displaySexNotUpdatableError();
            return;
        }

        String email = tfEmail.getText().strip();
        if (!email.equals( selectedUser.getEmail() )) {
            tfEmail.setText( selectedUser.getEmail() );
            UpdateErrorPrinter.displayEmailNotUpdatableError();
            return;
        }

        String userHouseNumber = tfHouseNumber.getText().strip();
        if (registerService.isEmpty( userHouseNumber )) {
            ErrorPrinter.displayEmptyFieldError();
            tfHouseNumber.requestFocus();
            return;
        }
        if (registerService.isFieldHasLetter( userHouseNumber )) {
            ErrorPrinter.displayFieldHasLetterError();
            tfHouseNumber.requestFocus();
            return;
        }

        String userPurokNumber = tfPurok.getText().strip();
        if (registerService.isEmpty( userPurokNumber )) {
            ErrorPrinter.displayEmptyFieldError();
            tfPurok.requestFocus();
            return;
        }
        if (registerService.isFieldHasLetter( userPurokNumber )) {
            ErrorPrinter.displayFieldHasLetterError();
            tfPurok.requestFocus();
            return;
        }

        String selectedProvinceName = cbProvince.getSelectionModel().getSelectedItem();
        if (selectedProvinceName.isEmpty()) {
            ErrorPrinter.displayEmptyFieldError();
            cbProvince.requestFocus();
            return;
        }

        String selectedCityName = cbCity.getSelectionModel().getSelectedItem();
        if (selectedCityName.isEmpty()) {
            ErrorPrinter.displayEmptyFieldError();
            cbCity.requestFocus();
            return;
        }

        String selectedBaranggayName = cbBaranggay.getSelectionModel().getSelectedItem();
        if (selectedBaranggayName.isEmpty()) {
            ErrorPrinter.displayEmptyFieldError();
            cbBaranggay.requestFocus();
            return;
        }

        Alert updateAlert = new Alert(Alert.AlertType.CONFIRMATION);
        updateAlert.setContentText("Are you sure you want to save the changes you make?");
        Optional<ButtonType> selectedButtonType = updateAlert.showAndWait();
        if (selectedButtonType.orElse(ButtonType.CANCEL) != ButtonType.OK) return;

        int id = Integer.parseInt( tfId.getText().strip() );
        dashBoardService.updateUser(
                id,
                firstName,
                middleName,
                lastName,
                phoneNumber,
                userHouseNumber,
                userPurokNumber,
                selectedProvinceName,
                selectedCityName,
                selectedBaranggayName,
                selectedUser
        );

        clearFields();

        updateTableContent();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Record updated with changes you make!");
        alert.show();
    }

    @FXML
    public void btnInsertPressed(ActionEvent actionEvent) {
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
            ErrorPrinter.displayEmptyFieldError();
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

        LocalDate birthDay = birthDate.getValue();
        if (birthDay == null) {
            ErrorPrinter.displayEmptyFieldError();
            birthDate.requestFocus();
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

        registerService.saveUser(
                email,
                null,
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

        clearFields();

        updateTableContent();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Record inserted successfully!");
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

    @FXML
    public void tblRowPressed(Event event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Do you want to replace all the fields with this record?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(ButtonType.CANCEL) != ButtonType.OK) {
            return;
        }

        try {
            User fetchUser = tblRegistrationInfo.getSelectionModel().getSelectedItem();

            tfId.setText( String.valueOf(fetchUser.getId()) );
            tfFirstName.setText( fetchUser.getFirstName() );
            tfMiddleName.setText( fetchUser.getMiddleName() );
            tfLastName.setText( fetchUser.getLastName() );
            tfPhoneNumber.setText( fetchUser.getPhoneNumber() );
            birthDate.setValue( fetchUser.getBirthDay() );
            selectSex( fetchUser.getSex() );
            tfEmail.setText( fetchUser.getEmail() );

            tfHouseNumber.setText( String.valueOf(fetchUser.getHouseNumber()) );
            tfPurok.setText( String.valueOf(fetchUser.getPurokNumber()) );

            cbBaranggay.setValue( fetchUser.getBaranggayName() );
            cbCity.setValue( fetchUser.getCityName() );
            cbProvince.setValue( fetchUser.getProvinceName() );
        } catch (NullPointerException e) {
            Alert selectedIsNull = new Alert(Alert.AlertType.WARNING);
            selectedIsNull.setContentText("Please select a user with record!");
            selectedIsNull.show();
            System.out.println("Cursor pointer not selecting anything");
        }
    }

    private void updateTableContent() {
        ObservableList<User> users = tblRegistrationInfo.getItems();
        users.setAll( dashBoardService.fetchUserDataList() );
        tblRegistrationInfo.setItems( users );
    }

    private void clearFields() {
        tfId.setText( "" );
        tfFirstName.setText( "" );
        tfMiddleName.setText( "" );
        tfLastName.setText( "" );
        tfPhoneNumber.setText( "" );
        birthDate.setValue( null );

        rbMale.setSelected(true);
        tfEmail.setText( "" );

        tfHouseNumber.setText( "" );
        tfPurok.setText( "" );

        cbBaranggay.setValue( null );
        cbCity.setValue( null );
        cbProvince.setValue( null );
    }

    private void selectSex(String sex) {
        if (sex.equals("MALE")) {
            rbMale.setSelected(true);
            return;
        }
        rbFemale.setSelected(true);
    }

    @FXML
    public void btnExportPressed() {
        
    }
}
