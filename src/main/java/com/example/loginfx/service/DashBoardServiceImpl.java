package com.example.loginfx.service;

import com.example.loginfx.model.User;
import com.example.loginfx.repository.CrudRepository;
import com.example.loginfx.repository.CrudRepositoryImpl;

import java.util.List;

public class DashBoardServiceImpl implements DashBoardService {

    private final CrudRepository crudRepository = new CrudRepositoryImpl();

    @Override
    public List<User> fetchUserDataList() {
        return this.crudRepository.fetchUserDataList();
    }

    @Override
    public void delete(int id, String email) {
        this.crudRepository.delete(id, email);
    }

    @Override
    public void updateUser(int id,
                       String firstName,
                       String middleName,
                       String lastName,
                       String phoneNumber,
                       String userHouseNumber,
                       String userPurokNumber,
                       String selectedProvinceName,
                       String selectedCityName,
                       String selectedBaranggayName,
                       User selectedUser) {

        int addressId = crudRepository.fetchAddressIdForDeletion( id ).orElseThrow();

        if (!firstName.equals( selectedUser.getFirstName() )) {
            crudRepository.updateFirstName(id, firstName);
        }
        if (!middleName.equals( selectedUser.getMiddleName() )) {
            crudRepository.updateMiddleName(id, middleName);
        }
        if (!lastName.equals( selectedUser.getLastName() )) {
            crudRepository.updateLastName(id, lastName);
        }
        if (!phoneNumber.equals( selectedUser.getPhoneNumber() )) {
            crudRepository.updatePhoneNumber(id, phoneNumber);
        }

        int houseNumber = Integer.parseInt( userHouseNumber );
        if (houseNumber != selectedUser.getHouseNumber()){
            crudRepository.updateHouseNumber(addressId, houseNumber);
        }

        int purokNumber = Integer.parseInt( userPurokNumber );
        if (purokNumber != selectedUser.getPurokNumber()) {
            crudRepository.updatePurokNumber(addressId, purokNumber);
        }

        int provinceId = crudRepository.fetchIdOfSelectedProvince( selectedProvinceName ).orElseThrow();
        if (!selectedProvinceName.equals( selectedUser.getProvinceName() )) {
            crudRepository.updateProvince(addressId, provinceId);
        }
        int cityId = crudRepository.fetchIdOfSelectedCity(selectedCityName, provinceId).orElseThrow();
        if (!selectedCityName.equals( selectedUser.getCityName() )) {
            crudRepository.updateCity(addressId, cityId);
        }
        int baranggayId = crudRepository.fetchIdOfSelectedBaranggay(selectedBaranggayName, cityId).orElseThrow();
        if (!selectedBaranggayName.equals( selectedUser.getBaranggayName() )) {
            crudRepository.updateBaranggay(addressId, baranggayId);
        }
    }
}
