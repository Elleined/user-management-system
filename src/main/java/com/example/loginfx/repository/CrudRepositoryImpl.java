package com.example.loginfx.repository;


import com.example.loginfx.model.User;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CrudRepositoryImpl implements CrudRepository {

    private final ReadRepository readRepository = new ReadRepositoryImpl();

    private final DeleteRepository deleteRepository = new DeleteRepositoryImpl();

    private final InsertRepository insertRepository = new InsertRepositoryImpl();

    private final UpdateRepository updateRepository = new UpdateRepositoryImpl();


    @Override
    public List<User> fetchUserDataList() {
        return this.readRepository.fetchUserDataList();
    }

    @Override
    public @NotNull List<String> fetchEmailList() {
        return this.readRepository.fetchEmailList();
    }

    @Override
    public Optional<String> fetchPasswordViaEmail(String email) {
        return this.readRepository.fetchPasswordViaEmail( email );
    }

    @Override
    public void insertLogin(String email, String pass) {
        this.insertRepository.insertLogin(email, pass);
    }


    @Override
    public @NotNull List<String> fetchProvinceList() {
        return this.readRepository.fetchProvinceList();
    }

    @Override
    public @NotNull List<String> fetchCityList(int provinceId) {
        return this.readRepository.fetchCityList( provinceId );
    }

    @Override
    public @NotNull List<String> fetchBaranggayList(int cityId) {
        return this.readRepository.fetchBaranggayList( cityId );
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedProvince(String provinceName) {
        return this.readRepository.fetchIdOfSelectedProvince( provinceName );
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedCity(String cityName, int provinceId) {
        return this.readRepository.fetchIdOfSelectedCity(cityName, provinceId);
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedBaranggay(String baranggayName, int cityId) {
        return this.readRepository.fetchIdOfSelectedBaranggay(baranggayName, cityId);
    }

    @Override
    public void insertAddress(int houseNumber,
                              int purokNumber,
                              int provinceId,
                              int cityId,
                              int baranggayId) {

        this.insertRepository.insertAddress(houseNumber, purokNumber, provinceId, cityId, baranggayId);
    }

    @Override
    public void insertRegistration(String firstName,
                                   String middleName,
                                   String lastName,
                                   String phoneNumber,
                                   LocalDate bDay,
                                   String sex,
                                   int addressId,
                                   String emailAddress) {

        this.insertRepository.insertRegistration(
                firstName,
                middleName,
                lastName,
                phoneNumber,
                bDay,
                sex,
                addressId,
                emailAddress);
    }

    @Override
    public Optional<Integer> fetchCurrentAddressId() {
        return this.readRepository.fetchCurrentAddressId();
    }

    @Override
    public void delete(int id, String email) {
        this.deleteRepository.delete(id, email);
    }

    @Override
    public Optional<Integer> fetchAddressIdForDeletion(int id) {
        return this.readRepository.fetchAddressIdForDeletion( id );
    }

    @Override
    public void updateFirstName(int id, String newFirstName) {
        this.updateRepository.updateFirstName(id, newFirstName);
    }

    @Override
    public void updateMiddleName(int id, String newMiddleName) {
        this.updateRepository.updateMiddleName(id, newMiddleName);
    }

    @Override
    public void updateLastName(int id, String newLastName) {
        this.updateRepository.updateLastName(id, newLastName);
    }

    @Override
    public void updatePhoneNumber(int id, String newPhoneNumber) {
        this.updateRepository.updatePhoneNumber(id, newPhoneNumber);
    }

    @Override
    public void updateBaranggay(int addressId, int newBaranggayId) {
        this.updateRepository.updateBaranggay(addressId, newBaranggayId);
    }

    @Override
    public void updateCity(int addressId, int newCityId) {
        this.updateRepository.updateCity(addressId, newCityId);
    }

    @Override
    public void updateProvince(int addressId, int newProvinceId) {
        this.updateRepository.updateProvince(addressId, newProvinceId);
    }

    @Override
    public void updateHouseNumber(int addressId, int newHouseNumber) {
        this.updateRepository.updateHouseNumber(addressId, newHouseNumber);
    }

    @Override
    public void updatePurokNumber(int addressId, int newPurokNumber) {
        this.updateRepository.updatePurokNumber(addressId, newPurokNumber);
    }
}
