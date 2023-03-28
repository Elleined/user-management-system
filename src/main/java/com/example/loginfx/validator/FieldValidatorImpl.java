package com.example.loginfx.validator;

import com.example.loginfx.repository.CrudRepository;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FieldValidatorImpl implements FieldValidator {

    private final CrudRepository crudRepository;

    public FieldValidatorImpl(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public boolean isEmpty(@NotNull String field) {
        return field.isEmpty();
    }

    @Override
    public boolean isEmailValid(@NotNull String email) {
        return !email.endsWith("@gmail.com") || email.startsWith("@");
    }

    @Override
    public boolean isPasswordCorrect(@NotNull String inputPassword, String fetchPassword) {
        return inputPassword.equals(fetchPassword);
    }

    @Override
    public boolean isEmailExist(String email) {
        return crudRepository.fetchEmailList().contains(email);
    }

    @Override
    public boolean isNameHasDigit(@NotNull String field) {
        return getPassCharArray( field ).stream().anyMatch(Character::isDigit);
    }

    @Override
    public boolean isFieldHasLetter(String phoneNumber) {
        return getPassCharArray( phoneNumber ).stream().anyMatch(Character::isLetter);
    }

    @Override
    public boolean isPhone11NumberLong(@NotNull String phoneNumber) {
        return phoneNumber.length() == 11;
    }

    @Override
    public boolean isPhoneStartWith09(@NotNull String phoneNumber) {
        return phoneNumber.startsWith("09");
    }

    @Override
    public boolean isEmailLegibleForLogin(String email) {
        return this.crudRepository.fetchPasswordViaEmail(email).isEmpty();
    }

    private @NotNull ArrayList<Character> getPassCharArray(@NotNull String field) {
        ArrayList<Character> passChars = new ArrayList<>();
        for (Character character : field.toCharArray()) {
            passChars.add(character);
        }
        return passChars;
    }
}
