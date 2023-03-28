package com.example.loginfx.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateRepositoryImpl implements UpdateRepository {

    @Override
    public void updateFirstName(int id, String newFirstName) {
        final String sqlQuery = "{call updateFirstName(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, id);
            query.setString(2, newFirstName);

            query.executeUpdate();
            System.out.println("Update of first name success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of first name failed!");
        }
    }

    @Override
    public void updateMiddleName(int id, String newMiddleName) {
        final String sqlQuery = "{call updateMiddleName(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, id);
            query.setString(2, newMiddleName);

            query.executeUpdate();
            System.out.println("Update of middle name success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of middle name failed!");
        }
    }

    @Override
    public void updateLastName(int id, String newLastName) {
        final String sqlQuery = "{call updateLastName(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, id);
            query.setString(2, newLastName);

            query.executeUpdate();
            System.out.println("Update of last name success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of last name failed!");
        }
    }

    @Override
    public void updatePhoneNumber(int id, String newPhoneNumber) {
        final String sqlQuery = "{call updatePhoneNumber(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, id);
            query.setString(2, newPhoneNumber);

            query.executeUpdate();
            System.out.println("Update of phone number success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of phone number failed!");
        }
    }

    @Override
    public void updateBaranggay(int addressId, int newBaranggayId) {
        final String sqlQuery = "{call updateBaranggay(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, addressId);
            query.setInt(2, newBaranggayId);

            query.executeUpdate();
            System.out.println("Update of baranggay success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of baranggay failed!");
        }
    }

    @Override
    public void updateCity(int addressId, int newCityId) {
        final String sqlQuery = "{call updateCity(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, addressId);
            query.setInt(2, newCityId);

            query.executeUpdate();
            System.out.println("Update of city success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of city failed!");
        }
    }

    @Override
    public void updateProvince(int addressId, int newProvinceId) {
        final String sqlQuery = "{call updateProvince(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, addressId);
            query.setInt(2, newProvinceId);

            query.executeUpdate();
            System.out.println("Update of province success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of province failed!");
        }
    }

    @Override
    public void updateHouseNumber(int addressId, int newHouseNumber) {
        final String sqlQuery = "{call updateHouseNumber(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, addressId);
            query.setInt(2, newHouseNumber);

            query.executeUpdate();
            System.out.println("Update of house number success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of house number failed!");
        }
    }

    @Override
    public void updatePurokNumber(int addressId, int newPurokNumber) {
        final String sqlQuery = "{call updatePurokNumber(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, addressId);
            query.setInt(2, newPurokNumber);

            query.executeUpdate();
            System.out.println("Update of purok number success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Update of purok number failed!");
        }
    }
}
