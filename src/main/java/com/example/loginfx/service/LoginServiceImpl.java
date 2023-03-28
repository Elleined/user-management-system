package com.example.loginfx.service;

import com.example.loginfx.validator.FieldValidator;
import com.example.loginfx.validator.FieldValidatorImpl;
import com.example.loginfx.repository.CrudRepository;
import com.example.loginfx.repository.CrudRepositoryImpl;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {
    private final CrudRepository crudRepository = new CrudRepositoryImpl();
    private final FieldValidator fieldValidator = new FieldValidatorImpl( new CrudRepositoryImpl() );

    @Override
    public boolean isEmpty(String field) {
        return this.fieldValidator.isEmpty( field );
    }

    @Override
    public boolean isEmailValid(String email) {
        return this.fieldValidator.isEmailValid( email );
    }

    @Override
    public boolean isPasswordCorrect(String inputPassword, String fetchPassword) {
        return this.fieldValidator.isPasswordCorrect(inputPassword, fetchPassword);
    }

    @Override
    public boolean isEmailExist(String email) {
        return this.fieldValidator.isEmailExist( email );
    }

    @Override
    public boolean isEmailLegibleForLogin(String email) {
        return this.fieldValidator.isEmailLegibleForLogin( email );
    }

    @Override
    public Optional<String> callPasswordGetter(String email) {
        return this.crudRepository.fetchPasswordViaEmail( email );
    }
}
