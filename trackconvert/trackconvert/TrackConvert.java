package trackconvert;

import java.util.Scanner;
import java.sql.*;

public class TrackConvert {
    public static void main(String[] args) {
        double dblTotalTime = 0.0, dblTimeMin, dblTimeHr, dblTimeSec, convertedTotalTime;
        String timeHr, timeMin, timeSec, convertedTime = "";
        String[] totalTime;
        Scanner scanner = new Scanner(System.in);

        introPrompt();

        while (true) {

            System.out.print("Enter your gender ('m' for Male, 'f' for Female):");
            String gender = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter your performance distance:");
            String event = scanner.nextLine().trim();

            System.out.print("Enter time of your performance:");
            String perfTime = scanner.nextLine().trim();

            System.out.println("**(Flat, UnderSized, OverSized, Banked)**");
            System.out.print("Enter track size of your performance:");
            String perfTrack = scanner.nextLine().toLowerCase();

            System.out.println("**(Flat, UnderSized, OverSized, Banked)**");
            System.out.print("Enter converted track size:");
            String convertTrack = scanner.nextLine().toLowerCase();

            String conversionString = perfTrack + "_to_" + convertTrack;

            String sqlQuery = "SELECT " + conversionString + " FROM track_conversions WHERE gender = ? AND event = ?";
            System.out.println("Generated SQL: " + sqlQuery);

            System.out.println(gender + " " + event + " " + perfTime + " " + conversionString);

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
                 PreparedStatement printQuery = conn.prepareStatement(sqlQuery)) {

                printQuery.setString(1, gender);
                printQuery.setString(2, event);

                ResultSet rs = printQuery.executeQuery();

                if (rs.next()) {
                    convertedTime = rs.getString(1); // or rs.getString(conversionColumn)

                    if (perfTime.contains(":")) {
                        totalTime = perfTime.split(":");

                        if (totalTime.length == 3) {

                            timeHr = totalTime[0];
                            timeMin = totalTime[1];
                            timeSec = totalTime[2];

                            dblTimeHr = Double.parseDouble(timeHr);
                            dblTimeMin = Double.parseDouble(timeMin);
                            dblTimeSec = Double.parseDouble(timeSec);
                            dblTotalTime = (dblTimeHr * 3600) + (dblTimeMin * 60) + dblTimeSec;
                            

                        } else if (totalTime.length == 2) {
                            timeMin = totalTime[0];
                            timeSec = totalTime[1];

                            dblTimeMin = Double.parseDouble(timeMin);
                            dblTimeSec = Double.parseDouble(timeSec);
                            dblTotalTime = (dblTimeMin * 60) + dblTimeSec;


                        } else {
                            System.out.println("No matching conversion found in database.");
                        }
                    }
                }

                convertedTotalTime = Double.parseDouble(convertedTime) * dblTotalTime;

                int convertedMinutes = (int) (convertedTotalTime / 60);
                double convertedSeconds = convertedTotalTime % 60;
                String formattedTime = String.format("%d:%05.2f", convertedMinutes, convertedSeconds);

                System.out.println("================================================");
                System.out.println();
                System.out.println("Converted time: " + formattedTime);
                System.out.println();
                System.out.println("================================================");
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void introPrompt() {
        System.out.println("========================================");
        System.out.println("\t\t\t\t******");
        System.out.println("\t\t\tTrackConvert");
        System.out.println("\t\tWritten by: Austin Rippee");
        System.out.println("\t\t\t\t******");
        System.out.println("========================================");
    }
}