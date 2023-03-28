package com.example.loginfx.repository;

public interface UpdateRepository {

    void updateFirstName(int id, String newFirstName);
    void updateMiddleName(int id, String newMiddleName);
    void updateLastName(int id, String newLastName);
    void updatePhoneNumber(int id, String newPhoneNumber);
    void updateBaranggay(int addressId, int newBaranggayId);
    void updateCity(int addressId, int newCityId);

    void updateProvince(int addressId, int newProvinceId);

    void updateHouseNumber(int addressId, int newHouseNumber);
    void updatePurokNumber(int addressId, int newPurokNumber);
}
