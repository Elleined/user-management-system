package com.example.loginfx.service;

import java.util.Optional;

public interface LoginService {
    boolean isEmpty(String field);
    boolean isEmailValid(String email);

    boolean isPasswordCorrect(String inputPassword, String fetchPassword);

    boolean isEmailExist(String email);

    Optional<String> callPasswordGetter(String password);

    boolean isEmailLegibleForLogin(String email);
}
