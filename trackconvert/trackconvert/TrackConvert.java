package trackconvert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class TrackConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM track_conversions WHERE 1=1");
        List<String> parameters = new ArrayList<>();

        while (true) {

            System.out.print("Enter your gender ('m' for Male, 'f' for Female:");
            String gender = scanner.nextLine().trim();
            if (!gender.isEmpty()) {
                sqlQuery.append(" AND gender = ?");
            }

            System.out.print("Enter your performance distance:");
            String event = scanner.nextLine().trim();
            if (!event.isEmpty()) {
                sqlQuery.append(" AND event = ?");
            }

            System.out.print("Enter time of your performance:");
            String perfTime = scanner.nextLine().trim();

            System.out.println("**(Flat, UnderSized, OverSized, Banked)**");
            System.out.print("Enter track size of your performance:");
            String perfTrack = scanner.nextLine();

            System.out.println("**(Flat, UnderSized, OverSized, Banked)**");
            System.out.print("Enter converted track size:");
            String convertTrack = scanner.nextLine();

            //check for method with this combination
            //filter table

            sqlQuery.append(";");
            System.out.println("Generated SQL: " + sqlQuery);

            System.out.println(gender + " " + event + " " + perfTime + " " + perfTrack + " " + convertTrack);

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
                 PreparedStatement pstmt = conn.prepareStatement(sqlQuery.toString())) {

                for (int i = 0; i < parameters.size(); i++) {
                    pstmt.setString(i + 1, parameters.get(i)); // JDBC indices start at 1
                }

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.printf("Gender: %s, Event: %s%n",
                            rs.getString("gender"),
                            rs.getString("event"));
                }

            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
