package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;

// handles database connection
public class DBConnection {

    static String url  = "jdbc:mysql://localhost:3306/employeedb";
    static String user = "root";
    static String pass = "aditya09"; // change this to your MySQL password

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}
