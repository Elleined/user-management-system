package com.example.loginfx.service;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RegisterService {

    boolean isEmpty(String field);
    boolean isEmailValid(String email);

    boolean isPasswordCorrect(String inputPassword, String fetchPassword);

    boolean isEmailExist(String email);

    boolean isNameHasDigit(String field);

    boolean isFieldHasLetter(String phoneNumber);

    boolean isPhone11NumberLong(String phoneNumber);

    boolean isPhoneStartWith09(String phoneNumber);
    boolean isPassContainsSpecialChar(String pass);

    boolean isPassHasSpace(String pass);

    boolean isPassHasUpperCase(String pass);

    boolean isPassHasLowerCase(String pass);

    boolean isPass8CharsLong(String pass);

    boolean isPassHasDigit(String pass);

    @NotNull List<String> fetchBaranggayList(int cityId);
    @NotNull List<String> fetchProvinceList();

    @NotNull List<String> fetchCityList(int provinceId);

    Optional<Integer> fetchIdOfSelectedProvince(String provinceName);

    Optional<Integer> fetchIdOfSelectedCity(String cityName, int provinceId);

    Optional<Integer> fetchIdOfSelectedBaranggay(String baranggayName, int cityId);

    void saveUser(String email,
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
                  String sex);
}
