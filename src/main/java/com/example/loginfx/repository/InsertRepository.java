package com.example.loginfx.repository;

import java.time.LocalDate;

public interface InsertRepository {

    void insertLogin(String email, String pass);

    void insertAddress(int houseNumber,
                       int purokNumber,
                       int provinceId,
                       int cityId,
                       int baranggayId);

    void insertRegistration(String firstName,
                            String middleName,
                            String lastName,
                            String phoneNumber,
                            LocalDate bDay,
                            String sex,
                            int addressId,
                            String emailAddress);
}
