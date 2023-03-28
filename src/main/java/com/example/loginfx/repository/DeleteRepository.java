package com.example.loginfx.repository;

public interface DeleteRepository {

    void delete(int id, String email);
    void deleteEmail(String email);
    void deleteAddress(int addressId);
}
