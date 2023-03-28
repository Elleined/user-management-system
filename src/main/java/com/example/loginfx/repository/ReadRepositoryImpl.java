package com.example.loginfx.repository;

import com.example.loginfx.model.Address;
import com.example.loginfx.model.FullName;
import com.example.loginfx.model.User;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReadRepositoryImpl implements ReadRepository {
    @Override
    public List<User> fetchUserDataList() {
        List<User> userList = new ArrayList<>();
        final String sqlQuery = "{call getUserDataList()}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery );
             ResultSet result = query.executeQuery()) {

            while (result.next()) {
                FullName fullName = new FullName(
                        result.getString("first_name"),
                        result.getString("middle_name"),
                        result.getString("last_name")
                );

                Address address = new Address(
                        result.getInt("house_number"),
                        result.getInt("purok_number"),
                        result.getString("baranggay_name"),
                        result.getString("city_name"),
                        result.getString("province_name")
                );

                User user = new User(
                        result.getInt("user_id"),
                        fullName,
                        result.getString("email"),
                        result.getString("sex"),
                        result.getDate("birth_date").toLocalDate(),
                        result.getString("phone_number"),
                        address
                );
                userList.add( user );
            }
            System.out.println("Fetching all user data success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Cannot fetch all user data");
        }
        return userList;
    }

    @Override
    public @NotNull List<String> fetchEmailList() {
        final String sqlQuery = "{call getEmailList()}";
        List<String> emailList = new ArrayList<>();
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            ResultSet result = query.executeQuery();
            while (result.next()) {
                emailList.add(result.getString(1));
            }
            System.out.println("Fetching of email list success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching if email failed!");
        }
        return emailList;
    }

    @Override
    public Optional<String> fetchPasswordViaEmail(String email) {
        final String sqlQuery = "{? = call getPassword(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.registerOutParameter(1, Types.VARCHAR);
            query.setString(2, email);

            query.execute();

            String fetchedPassword = query.getString(1);
            System.out.println("Fetching of password via email success");
            return Optional.ofNullable( fetchedPassword );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching of password via email failed!");
        }
        return Optional.empty();
    }

    @Override
    public @NotNull List<String> fetchProvinceList() {
        List<String> provinceList = new ArrayList<>();
        final String sqlQuery = "{call getProvinceList()}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            ResultSet result = query.executeQuery();
            while (result.next()) {
                provinceList.add( result.getString(1) );
            }
            System.out.println("Fetching of province list success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching of province list failed!");
        }
        return provinceList;
    }

    @Override
    public @NotNull List<String> fetchCityList(int provinceId) {
        List<String> cityList = new ArrayList<>();
        final String sqlQuery = "{call getCityListViaProvinceId(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.setInt(1, provinceId);
            ResultSet result = query.executeQuery();
            while (result.next()) {
                cityList.add( result.getString(1) );
            }
            System.out.println("Fetching of city list success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching of city list failed!");
        }
        return cityList.stream()
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public @NotNull List<String> fetchBaranggayList(int cityId) {
        List<String> baranggayList = new ArrayList<>();
        final String sqlQuery = "{call getBaranggayListViaCityId(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall(sqlQuery)) {

            query.setInt(1, cityId);
            ResultSet result = query.executeQuery();
            while (result.next()) {
                baranggayList.add(result.getString(1));
            }

            System.out.println("Fetching of baranggay list success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching of baranggay list failed!");
        }
        return baranggayList.stream()
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedProvince(String provinceName) {
        final String sqlQuery = "{? = call getIdOfSelectedProvince(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.registerOutParameter(1, Types.INTEGER);
            query.setString(2, provinceName);

            query.execute();

            int fetchedProvinceId = query.getInt(1);
            System.out.println("Fetching id of selected province success! " + fetchedProvinceId);
            return Optional.of( fetchedProvinceId );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching id of selected province failed!");
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedCity(String cityName, int provinceId) {
        final String sqlQuery = "{? = call getIdOfSelectedCity(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.registerOutParameter(1, Types.INTEGER);
            query.setString(2, cityName);
            query.setInt(3, provinceId);

            query.execute();

            int fetchCityId = query.getInt(1);
            System.out.println("Fetching id of selected city success! " + fetchCityId);
            return Optional.of( fetchCityId );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching id of selected city failed!");
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> fetchIdOfSelectedBaranggay(String baranggayName, int cityId) {
        final String sqlQuery = "{? = call getIdOfSelectedBaranggay(?, ?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.registerOutParameter(1, Types.INTEGER);
            query.setString(2, baranggayName);
            query.setInt(3, cityId);

            query.execute();

            int fetchedBaranggayId = query.getInt(1);
            System.out.println("Fetching id of selected baranggay success! " + fetchedBaranggayId);
            return Optional.of( fetchedBaranggayId );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching id of selected baranggay failed!");
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> fetchCurrentAddressId() {
        final String sqlQuery = "{? = call getCurrentAddressId()}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.registerOutParameter(1, Types.INTEGER);
            query.execute();

            System.out.println("Fetching the current address id success!");
            return Optional.of( query.getInt(1) );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching the current address id failed");
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> fetchAddressIdForDeletion(int id) {
        final String sqlQuery = "{? = call getAddressId(?)}";
        try (Connection conn = MySQLConnection.getConnection();
             CallableStatement query = conn.prepareCall( sqlQuery )) {

            query.registerOutParameter(1, Types.INTEGER);
            query.setInt(2, id);

            query.execute();

            System.out.println("Fetching of address id for deletion success!!");
            return Optional.of( query.getInt(1) );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Fetching of address id for deletion failed!");
        }
        return Optional.empty();
    }

}
