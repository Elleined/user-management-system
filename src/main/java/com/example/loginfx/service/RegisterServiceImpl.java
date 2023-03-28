package com.example.loginfx.service;

import com.example.loginfx.repository.CrudRepository;
import com.example.loginfx.repository.CrudRepositoryImpl;
import com.example.loginfx.validator.FieldValidator;
import com.example.loginfx.validator.FieldValidatorImpl;
import com.example.loginfx.validator.StrongPasswordValidator;
import com.example.loginfx.validator.StrongPasswordValidatorImpl;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RegisterServiceImpl implements RegisterService {

    private final CrudRepository crudRepository = new CrudRepositoryImpl();
    private final StrongPasswordValidator strongPasswordValidator = new StrongPasswordValidatorImpl();
    private final FieldValidator fieldValidator = new FieldValidatorImpl(crudRepository);

    @Override
    public boolean isPassContainsSpecialChar(String pass) {
        return strongPasswordValidator.isPassContainsSpecialChar( pass );
    }

    @Override
    public boolean isPassHasSpace(String pass) {
        return strongPasswordValidator.isPassHasSpace( pass );
    }

    @Override
    public boolean isPassHasUpperCase(String pass) {
        return strongPasswordValidator.isPassHasUpperCase( pass );
    }

    @Override
    public boolean isPassHasLowerCase(String pass) {
        return strongPasswordValidator.isPassHasLowerCase( pass );
    }

    @Override
    public boolean isPass8CharsLong(String pass) {
        return strongPasswordValidator.isPass8CharsLong( pass );
    }

    @Override
    public boolean isPassHasDigit(String pass) {
        return strongPasswordValidator.isPassHasDigit( pass );
    }

    @Override
    public boolean isNameHasDigit(String field) {
        return this.fieldValidator.isNameHasDigit( field );
    }

    @Override
    public boolean isFieldHasLetter(String phoneNumber) {
        return this.fieldValidator.isFieldHasLetter( phoneNumber );
    }

    @Override
    public boolean isEmpty(String field) {
        return fieldValidator.isEmpty( field );
    }

    @Override
    public boolean isEmailValid(String email) {
        return fieldValidator.isEmailValid( email );
    }

    @Override
    public boolean isPasswordCorrect(String inputPassword, String fetchPassword) {
        return fieldValidator.isPasswordCorrect(inputPassword, fetchPassword);
    }

    @Override
    public boolean isEmailExist(String email) {
        return fieldValidator.isEmailExist( email );
    }

    @Override
    public @NotNull List<String> fetchBaranggayList(int cityId) {
        return this.crudRepository.fetchBaranggayList( cityId );
    }

    @Override
    public @NotNull List<String> fetchProvinceList() {
        return this.crudRepository.fetchProvinceList();
    }

    @Override
    public @NotNull List<String> fetchCityList(int provinceId) {
        return this.crudRepository.fetchCityList( provinceId );
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedProvince(String provinceName) {
        return this.crudRepository.fetchIdOfSelectedProvince( provinceName );
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedCity(String cityName, int provinceId) {
        return this.crudRepository.fetchIdOfSelectedCity(cityName, provinceId);
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedBaranggay(String baranggayName, int cityId) {
        return this.crudRepository.fetchIdOfSelectedBaranggay(baranggayName, cityId);
    }


    @Override
    public void saveUser(String email,
                         String confirmPassword,
                         String houseNumber,
                         String purokNumber,
                         int selectedProvinceId,
                         int selectedCityId,
                         int selectedBaranggayId,
                         String firstName,
                         String middleName,
                         String lastName,
                         String phoneNumber,
                         LocalDate birthDay,
                         String sex) {

        crudRepository.insertLogin(email, confirmPassword);

        crudRepository.insertAddress(
                Integer.parseInt(houseNumber),
                Integer.parseInt(purokNumber),
                selectedProvinceId,
                selectedCityId,
                selectedBaranggayId);

        int currentAddressId = crudRepository.fetchCurrentAddressId().orElseThrow();
        crudRepository.insertRegistration(
                firstName,
                middleName,
                lastName,
                phoneNumber,
                birthDay,
                sex,
                currentAddressId,
                email
        );
    }

    @Override
    public boolean isPhone11NumberLong(String phoneNumber) {
       return !fieldValidator.isPhone11NumberLong(phoneNumber);
    }

    @Override
    public boolean isPhoneStartWith09(String phoneNumber) {
        return !fieldValidator.isPhoneStartWith09(phoneNumber);
    }


}
