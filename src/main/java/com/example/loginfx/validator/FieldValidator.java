package com.example.loginfx.validator;

public interface FieldValidator {

    boolean isEmpty(String field);
    boolean isEmailValid(String email);

    boolean isPasswordCorrect(String inputPassword, String fetchPassword);

    boolean isEmailExist(String email);

    boolean isNameHasDigit(String field);

    boolean isFieldHasLetter(String phoneNumber);

    boolean isPhone11NumberLong(String phoneNumber);

    boolean isPhoneStartWith09(String phoneNumber);
    boolean isEmailLegibleForLogin(String email);

}
