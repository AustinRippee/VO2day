package database;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
/*        String createTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        email TEXT
                    );
                """;*/

        //String insertUser = "INSERT INTO users(name, email) VALUES(?, ?)";

        try (Connection conn = DBConnector.connect();
             Statement stmt = conn.createStatement()) {

            // Create the table
            //stmt.execute(createTable);

            // Insert a user
/*            try (PreparedStatement pstmt = conn.prepareStatement(insertUser)) {
                pstmt.setString(1, "Austin Rippee");
                pstmt.setString(2, "austin@example.com");
                pstmt.executeUpdate();
                System.out.println("Inserted user successfully.");
            }*/

            // Read and print users
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.printf("User #%d: %s (%s)%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}