package com.example.loginfx.repository;

import org.junit.jupiter.api.Test;

class UpdateRepositoryImplTest {

    private final UpdateRepository updateRepository = new UpdateRepositoryImpl();

    @Test
    void updateFirstName() {
        updateRepository.updateFirstName(4, "FIRSTNAME");

    }

    @Test
    void updateMiddleName() {
        updateRepository.updateMiddleName(4, "MIDDLENAME");
    }

    @Test
    void updateLastName() {
        updateRepository.updateLastName(4, "LASTNAME");
    }

    @Test
    void updatePhoneNumber() {
        updateRepository.updatePhoneNumber(4, "09111111111");
    }

    @Test
    void updateBaranggay() {
        updateRepository.updateBaranggay(4, 2);
    }

    @Test
    void updateCity() {
        updateRepository.updateCity(4, 2);
    }

    @Test
    void updateProvince() {
        updateRepository.updateProvince(4 ,2);
    }

    @Test
    void updateHouseNumber() {
        updateRepository.updateHouseNumber(4, 2);
    }

    @Test
    void updatePurokNumber() {
        updateRepository.updatePurokNumber(4, 2);
    }
}