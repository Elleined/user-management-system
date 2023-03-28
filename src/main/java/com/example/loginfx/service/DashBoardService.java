package com.example.loginfx.service;

import com.example.loginfx.model.User;

import java.util.List;

public interface DashBoardService {

    List<User> fetchUserDataList();

    void delete(int id, String email);

    void updateUser(int id,
                String firstName,
                String middleName,
                String lastName,
                String phoneNumber,
                String userHouseNumber,
                String userPurokNumber,
                String selectedProvinceName,
                String selectedCityName,
                String selectedBaranggayName,
                User selectedUser);
}
