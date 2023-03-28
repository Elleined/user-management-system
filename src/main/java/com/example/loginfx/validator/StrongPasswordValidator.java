package com.example.loginfx.validator;

public interface StrongPasswordValidator {
    boolean isPassContainsSpecialChar(String pass);

    boolean isPassHasSpace(String pass);

    boolean isPassHasUpperCase(String pass);

    boolean isPassHasLowerCase(String pass);

    boolean isPass8CharsLong(String pass);

    boolean isPassHasDigit(String pass);
}
