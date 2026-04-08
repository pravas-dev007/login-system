package com.pravas.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/studentdb",
                "postgres",
                "123"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
