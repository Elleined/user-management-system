package com.example.loginfx.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertRepositoryImpl implements InsertRepository {
    @Override
    public void insertLogin(String email, String pass) {
        final String sqlQuery = "{call insertLogin(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setString(1, email);
            query.setString(2, pass);

            query.executeUpdate();
            System.out.println("User credential successfully inserted!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Insertion Failed");
        }
    }

    @Override
    public void insertAddress(int houseNumber, int purokNumber, int provinceId, int cityId, int baranggayId) {
        final String sqlQuery = "{call insertAddress(?, ?, ?, ?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, houseNumber);
            query.setInt(2, purokNumber);
            query.setInt(3, provinceId);
            query.setInt(4, cityId);
            query.setInt(5, baranggayId);

            query.executeUpdate();

            System.out.println("Insertion of address success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Insertion of address failed!");
        }
    }



    @Override
    public void insertRegistration(String firstName, String middleName, String lastName, String phoneNumber, LocalDate bDay, String sex, int addressId, String emailAddress) {
        final String sqlQuery = "{call insertRegistration(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setString(1, firstName);
            query.setString(2, middleName);
            query.setString(3, lastName);
            query.setString(4, phoneNumber);
            query.setDate(5, Date.valueOf(bDay));
            query.setString(6, sex);
            query.setInt(7, addressId);
            query.setString(8,emailAddress);

            query.executeUpdate();
            System.out.println("Insertion of registration info success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Insertion of registration info failed!");
        }
    }
}
