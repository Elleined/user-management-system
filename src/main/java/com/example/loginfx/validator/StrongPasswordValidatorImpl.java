package com.example.loginfx.validator;

import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Value
public class StrongPasswordValidatorImpl implements StrongPasswordValidator {
    private final static List<Character> specialChars = Arrays.asList('@', '#', '$', '_', '/');

    @Override
    public boolean isPassContainsSpecialChar(String pass) {
        return specialChars.stream().noneMatch(c -> pass.contains(c.toString()));
    }

    @Override
    public boolean isPassHasSpace(String pass) {
        return pass.contains(" ");
    }

    @Override
    public boolean isPassHasUpperCase(String pass) {
        return getPasswordCharArray( pass ).stream().noneMatch(Character::isUpperCase);
    }

    @Override
    public boolean isPassHasLowerCase(String pass) {
        return getPasswordCharArray( pass ).stream().noneMatch(Character::isLowerCase);
    }

    @Override
    public boolean isPassHasDigit(String pass) {
        return getPasswordCharArray( pass ).stream().noneMatch(Character::isDigit);
    }

    @Override
    public boolean isPass8CharsLong(@NotNull String pass) {
        return pass.length() < 8;
    }

    private @NotNull ArrayList<Character> getPasswordCharArray(@NotNull String pass) {
        ArrayList<Character> passChars = new ArrayList<>();
        for (Character character : pass.toCharArray()) {
            passChars.add(character);
        }
        return passChars;
    }
}
