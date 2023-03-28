package com.example.loginfx.repository;

import com.example.loginfx.model.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface ReadRepository {
    List<User> fetchUserDataList();
    @NotNull List<String> fetchEmailList();

    Optional<String> fetchPasswordViaEmail(String email);

    @NotNull List<String> fetchProvinceList();

    @NotNull List<String> fetchCityList(int provinceId);

    @NotNull List<String> fetchBaranggayList(int cityId);

    Optional<Integer> fetchIdOfSelectedProvince(String provinceName);

    Optional<Integer> fetchIdOfSelectedCity(String cityName, int provinceId);

    Optional<Integer> fetchIdOfSelectedBaranggay(String baranggayName, int cityId);
    Optional<Integer> fetchCurrentAddressId();
    Optional<Integer> fetchAddressIdForDeletion(int id);
}
