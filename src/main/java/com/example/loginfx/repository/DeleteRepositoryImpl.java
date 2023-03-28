package com.example.loginfx.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteRepositoryImpl implements DeleteRepository {

    private final ReadRepository readRepository = new ReadRepositoryImpl();

    @Override
    public void delete(int id, String email) {
        final String sqlQuery = "{call deleteRegistrationInfo(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            int addressId = readRepository.fetchAddressIdForDeletion( id ).orElseThrow();

            query.setInt(1, id);
            query.executeUpdate();

            deleteAddress( addressId );

            deleteEmail( email );

            System.out.println("Deletion of record success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Deletion failed");
        }
    }



    @Override
    public void deleteEmail(String email) {
        final String sqlQuery = "{call deleteRegistrationEmail(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setString(1, email);
            query.executeUpdate();

            System.out.println("Email deleted successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Email deletion failed!");
        }
    }

    @Override
    public void deleteAddress(int addressId) {
        final String sqlQuery = "{call deleteRegistrationAddress(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, addressId);
            query.executeUpdate();

            System.out.println("Address deleted successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Address deletion failed!");
        }
    }
}
