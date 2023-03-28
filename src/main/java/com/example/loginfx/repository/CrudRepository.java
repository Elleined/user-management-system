package com.example.loginfx.repository;

import com.example.loginfx.model.User;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CrudRepository {

    List<User> fetchUserDataList();
    @NotNull List<String> fetchEmailList();

    Optional<String> fetchPasswordViaEmail(String email);

    void insertLogin(String email, String pass);

    @NotNull List<String> fetchProvinceList();

    @NotNull List<String> fetchCityList(int provinceId);

    @NotNull List<String> fetchBaranggayList(int cityId);

    Optional<Integer> fetchIdOfSelectedProvince(String provinceName);

    Optional<Integer> fetchIdOfSelectedCity(String cityName, int provinceId);

    Optional<Integer> fetchIdOfSelectedBaranggay(String baranggayName, int cityId);

    void insertAddress(int houseNumber, int purokNumber, int provinceId, int cityId, int baranggayId);

    void insertRegistration(String firstName,
                            String middleName,
                            String lastName,
                            String phoneNumber,
                            LocalDate bDay,
                            String sex,
                            int addressId,
                            String emailAddress);

    Optional<Integer> fetchCurrentAddressId();

    void delete(int id, String email);

    Optional<Integer> fetchAddressIdForDeletion(int id);

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
