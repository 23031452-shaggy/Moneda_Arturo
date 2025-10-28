package com.example.DBAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//SINGLETON
public class ConexionDBSingleton {
    private static ConexionDBSingleton instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/world";
    private final String USUARIO = "root";
    private final String PASSWORD = "turomon11";

    private ConexionDBSingleton() throws SQLException {
        connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public static ConexionDBSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexionDBSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
