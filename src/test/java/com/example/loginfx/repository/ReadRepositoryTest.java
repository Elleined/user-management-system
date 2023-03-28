package com.example.loginfx.repository;

import com.example.loginfx.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReadRepositoryTest {

    private final ReadRepository readRepository = new ReadRepositoryImpl();

    @Test
    void fetchUserDataList() {
        List<User> userList = readRepository.fetchUserDataList();
        User user = userList.get(0);
        System.out.println(user.getFirstName());
        System.out.println(user.getMiddleName());
        System.out.println(user.getLastName());
        System.out.println(user.getHouseNumber());
        System.out.println(user.getPurokNumber());
        System.out.println(user.getBaranggayName());
        System.out.println(user.getCityName());
        System.out.println(user.getProvinceName());
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getSex());
        System.out.println(user.getBirthDay());
        System.out.println(user.getPhoneNumber());
    }

    @Test
    void fetchEmailList() {
        readRepository.fetchEmailList().forEach(System.out::println);
    }

    @Test
    void fetchPasswordViaEmail() {
        System.out.println(readRepository.fetchPasswordViaEmail("demadegu@gmail.com").orElseThrow());
    }

    @Test
    void fetchProvinceList() {
        readRepository.fetchProvinceList().forEach(System.out::println);
    }

    @Test
    void fetchCityList() {
        readRepository.fetchCityList(55).forEach(System.out::println);
    }

    @Test
    void fetchBaranggayList() {
        readRepository.fetchBaranggayList(255).forEach(System.out::println);
    }

    @Test
    void fetchIdOfSelectedProvince() {
        int provinceId = readRepository.fetchIdOfSelectedProvince("Nueva Ecija").orElseThrow();
        System.out.println(provinceId);
    }

    @Test
    void fetchIdOfSelectedCity() {
        int cityId = readRepository.fetchIdOfSelectedCity("Cabanatuan City", 55).orElseThrow();
        System.out.println(cityId);
    }

    @Test
    void fetchIdOfSelectedBaranggay() {
        int brgyId = readRepository.fetchIdOfSelectedBaranggay("Sumacab Este", 284).orElseThrow();
        System.out.println(brgyId);
    }

    @Test
    void fetchCurrentAddressId() {
        int currentAddressId = readRepository.fetchCurrentAddressId().orElseThrow();
        System.out.println(currentAddressId);
    }
    @Test
    void fetchAddressIdForDeletion() {
        int userAddressId = readRepository.fetchAddressIdForDeletion(1).orElseThrow();
        System.out.println(userAddressId);
    }
}