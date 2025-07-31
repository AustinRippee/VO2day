package trainingpaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class TrainingPaces {
    public static void main(String[] args) {
        double dblTotalTime = 0.0, dblTimeMin, dblTimeHr, dblTimeSec, convertedTotalTime;
        String timeHr, timeMin, timeSec, convertedTime = "";
        String[] totalTime;
        Scanner scanner = new Scanner(System.in);

        introPrompt();

        System.out.println("Please enter your most recent race distance:");
        String raceDistance = scanner.nextLine();
        System.out.println("Please enter your most recent race time:");
        String raceTime = scanner.nextLine();

        //use time to create the query to filter out the VDOT race table
        //need a way to find the closest value from input race time.
        String sqlQuery = "";
        System.out.println("Generated SQL: " + sqlQuery);

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            PreparedStatement printQuery = conn.prepareStatement(sqlQuery)) {

            if (raceTime.contains(":")) {
                totalTime = raceTime.split(":");

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //either have a separate query or simply join on the ID from the VDOT race table
        //and combine to get the training paces

        //print out the training paces based on that as well as the VDOT score

        //BONUS: take this VDOT score and bring in comparable distances from PaceConvert
    }

    public static void introPrompt() {
        System.out.println("========================================");
        System.out.println("\t\t\t\t******");
        System.out.println("\t\t\tTrainingPaces");
        System.out.println("\t\tWritten by: Austin Rippee");
        System.out.println("\t\t\t\t******");
        System.out.println("========================================");
    }

}
