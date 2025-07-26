package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection connect() {
        Connection conn = null;
        try {
            // You can adjust the path or name of the database
            String url = "jdbc:sqlite:mydatabase.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
}