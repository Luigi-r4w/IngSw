package com.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    private static String jdbcURL="jdbc:postgresql://postgres:5432/DietiDeals24DB";
    private static String username="postgres";
    private static String password="1234";
    private static Connection con;

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(jdbcURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
