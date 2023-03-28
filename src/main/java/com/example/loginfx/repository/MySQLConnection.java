package com.example.loginfx.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface MySQLConnection {
    static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/activity_db", "user", "user");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Connection Failed!");
        }
        return connection;
    }
}
