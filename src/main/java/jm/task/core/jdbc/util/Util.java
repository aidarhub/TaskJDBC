package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String userName = "root";
    private static final String password = "ncoGQ73%px576@Bqzo";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/User?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("Connection");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Not connection");
        }
        return connection;
    }
}
