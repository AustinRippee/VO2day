package trackconvert;

import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class TrackConvert {
    public static void main(String[] args) {
        double dblTotalTime = 0.0, dblTimeMin, dblTimeHr, dblTimeSec, convertedTotalTime;
        String timeHr, timeMin, timeSec, convertedTime = "";
        String[] totalTime;
        Scanner scanner = new Scanner(System.in);
        boolean programDone = false;

        enum TrackConversions {
            undersized_to_flat,
            undersized_to_banked,
            oversized_to_flat,
            flat_to_oversized,
            undersized_to_oversized,
            flat_to_banked,
            banked_to_flat
        }

        List<String> Tracks = List.of(
                "undersized", "flat", "oversized", "banked"
        );

        List<String> distances = List.of(
                "200", "400", "800", "1000", "Mile", "3000",
                "5000", "4x400", "DMR"
        );

        introPrompt();

        while (true) {

            System.out.print("Enter your gender ('M' for Male, 'F' for Female):");
            String gender = scanner.nextLine().trim().toUpperCase();

            if (gender.equalsIgnoreCase("exit")) {
                System.out.println("Exiting TrackConvert...");
                break;
            }

            if (gender.equals("M") || gender.equals("F")) {

                while (true) {

                    System.out.print("Enter your performance distance (type (races) for list of distances):");
                    String event = scanner.nextLine().trim();

                    if (event.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting TrackConvert...");
                        System.exit(0);
                    }

                    if (event.equalsIgnoreCase("races")) {
                        System.out.println(distances);
                        continue;
                    }

                    if (distances.contains(event)) {
                        System.out.print("Enter time of your performance:");
                        String perfTime = scanner.nextLine().trim();
                        if (perfTime.equalsIgnoreCase("exit")) break;

                        System.out.println("**(Flat, UnderSized, OverSized, Banked)**");
                        System.out.print("Enter track size of your performance:");
                        String perfTrack = scanner.nextLine().toLowerCase();
                        if (perfTrack.equalsIgnoreCase("exit")) break;

                        if (!Tracks.contains(perfTrack)) {
                            System.out.println("Invalid track type entered.");
                            break;
                        }

                        System.out.println("**(Flat, UnderSized, OverSized, Banked)**");
                        System.out.print("Enter converted track size:");
                        String convertTrack = scanner.nextLine().toLowerCase();
                        if (convertTrack.equalsIgnoreCase("exit")) break;

                        if (!Tracks.contains(convertTrack)) {
                            System.out.println("Invalid track type entered.");
                            break;
                        }

                        String conversionString = perfTrack + "_to_" + convertTrack;
                        boolean conversionFound = false;

                        for (TrackConversions track : TrackConversions.values()) {
                            if (track.name().equalsIgnoreCase(conversionString)) {
                                conversionFound = true;

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
                                                System.out.println("Invalid time format. Use MM:SS or HH:MM:SS");
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
                                    System.out.println();
                                    break;

                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                        if (!conversionFound) {
                            System.out.println("Invalid track conversion type entered.");
                        }
                        break;
                    } else {
                        System.out.println("That is not a valid distance.");
                    }
                }
            } else {
                System.out.println("Enter a valid gender.");
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