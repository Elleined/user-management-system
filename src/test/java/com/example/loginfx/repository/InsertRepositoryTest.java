package com.example.loginfx.repository;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class InsertRepositoryTest {

    private final InsertRepository insertRepository = new InsertRepositoryImpl();

    @Test
    void insertLogin() {
        insertRepository.insertLogin("gred@gmail.com", "@greddy03");
    }

    @Test
    void insertAddress() {
        insertRepository.insertAddress(1, 1, 1, 1,1);
    }

    @Test
    void insertRegistration() {

        ReadRepository readRepository = new ReadRepositoryImpl();
        int currentAddressId = readRepository.fetchCurrentAddressId().orElseThrow();

        insertRepository.insertRegistration(
                "first",
                "middle",
                "last",
                "09876542378",
                LocalDate.of(2002, Month.OCTOBER, 3),
                "MALE",
                currentAddressId,
                "gred@gmail.com"
        );
    }
}