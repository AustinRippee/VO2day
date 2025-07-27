package paceconvert;

//import java.text.DecimalFormat;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class PaceConvert {

    static double resultScore = 0.0;

    public static void main(String[] args) {

        Map<String, List<String>> raceDistances = new LinkedHashMap<>();

        raceDistances.put("100m", Arrays.asList("100m", "100"));
        raceDistances.put("150m", Arrays.asList("150m", "150"));
        raceDistances.put("200m", Arrays.asList("200m", "200"));
        raceDistances.put("300m", Arrays.asList("300m", "300"));
        raceDistances.put("400m", Arrays.asList("400m", "400"));
        raceDistances.put("600m", Arrays.asList("600m", "600"));
        raceDistances.put("800m", Arrays.asList("800m", "800"));
        raceDistances.put("1000m", Arrays.asList("1000m", "1000", "1,000", "1,000m", "1k", "1km"));
        raceDistances.put("1500m", Arrays.asList("1500m", "1500", "1,500", "1,500m", "1.5k", "1.5km"));
        raceDistances.put("1600m", Arrays.asList("1600m", "1600", "1,600", "1,600m", "1.6k", "1.6km"));
        raceDistances.put("1mi", Arrays.asList("1 Mile", "1Mile", "Mile", "One Mile", "1609", "1609m", "1 mile", "1mile", "one mile", "One mile", "one Mile"));
        raceDistances.put("2000m", Arrays.asList("2000m", "2000", "2,000", "2,000m"));
        raceDistances.put("3000m", Arrays.asList("3000m", "3000", "3,000", "3,000m", "3k"));
        raceDistances.put("3200m", Arrays.asList("3200m", "3200", "3,200", "3,200m"));
        raceDistances.put("2mi", Arrays.asList("2mi", "2 Mile", "2 Miles", "2Mile", "2Miles", "Two Miles", "Two Mile", "3218", "3218m"));
        raceDistances.put("5000m", Arrays.asList("5000m", "5,000m", "5000", "5,000", "5k", "5km"));
        raceDistances.put("6000m", Arrays.asList("6000m", "6,000m", "6000", "6,000", "6k", "6km"));
        raceDistances.put("8000m", Arrays.asList("8000m", "8,000m", "8000", "8,000", "8k", "8km"));
        raceDistances.put("10000m", Arrays.asList("10000m", "10,000m", "10000", "10,000", "10k", "10km"));
        raceDistances.put("10mi", Arrays.asList("10 Miles", "10mi"));
        raceDistances.put("HalfM", Arrays.asList("Half Marathon", "HM", "Half", "13.1", "13.1mi", "13.1 Miles"));
        raceDistances.put("Marathon", Arrays.asList("Marathon", "M", "Full Marathon", "Full", "Mara", "26.2", "26.2mi", "26.2 Miles"));

        //DecimalFormat df_obj = new DecimalFormat("#.##");
        double dblTotalTime = 0.0, dblTimeMin, dblTimeHr, dblTimeSec;
        Scanner scanMain;
        String strInputRaceDistance, strInputRaceTime, timeHr, timeMin, timeSec, convertRace;
        String[] totalTime;
        scanMain = new Scanner(System.in);

        PrintUI.introPrompt();

        System.out.println("Would you like to upload a file? (y/n)");
        String fileInput = scanMain.nextLine();

        if (fileInput.equalsIgnoreCase("y")) {
            while (true) {
                PrintUI.fileIntroPrompt();

                System.out.println("Please enter a filename:");
                String inputFile = scanMain.nextLine();
                File inputFilePath = new File("C:\\Users\\Austin Rippee\\Vo2sDay\\assets\\" + inputFile);

                try {
                    Scanner scanner = new Scanner(inputFilePath);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine().trim();

                        if (line.isEmpty()) {
                            continue;
                        }

                        String[] values = line.split(",");

                        if (values.length < 3) {
                            System.out.println("Invalid line (must contain 3 values): " + line);
                            continue;
                        }

                        strInputRaceDistance = values[0];
                        strInputRaceTime = values[1];
                        convertRace = values[2];

                        if (!raceDistances.containsKey(strInputRaceDistance)) {
                            System.out.println("Not a valid race distance: " + strInputRaceDistance);
                            continue;
                        }

                        if (!raceDistances.containsKey(convertRace)) {
                            System.out.println("Not a valid conversion distance: " + convertRace);
                            continue;
                        }
                        try {
                            if (strInputRaceTime.contains(":")) {
                                totalTime = strInputRaceTime.split(":");

                                if (totalTime.length == 3) {
                                    dblTimeHr = Double.parseDouble(totalTime[0]);
                                    dblTimeMin = Double.parseDouble(totalTime[1]);
                                    dblTimeSec = Double.parseDouble(totalTime[2]);

                                    dblTotalTime = (dblTimeHr * 3600) + (dblTimeMin * 60) + dblTimeSec;

                                } else if (totalTime.length == 2) {

                                    dblTimeMin = Double.parseDouble(totalTime[0]);
                                    dblTimeSec = Double.parseDouble(totalTime[1]);
                                    dblTotalTime = (dblTimeMin * 60) + dblTimeSec;

                                } else {
                                    System.out.println("Invalid time format (use MM:SS or HH:MM:SS): " + strInputRaceTime);
                                    continue;
                                }
                            } else {
                                dblTotalTime = Double.parseDouble(strInputRaceTime);
                            }

                            Calculations.calcPrint(strInputRaceDistance, strInputRaceTime, dblTotalTime);
                            Calculations.convCalcPrint(strInputRaceDistance, strInputRaceTime, convertRace, resultScore);

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid time number format: " + strInputRaceTime);
                        }
                    }

                    scanner.close();

                } catch (FileNotFoundException e) {
                    System.err.println("CSV file not found: " + e.getMessage());
                }

            }
        } else if (fileInput.equalsIgnoreCase("n")) {
            while (true) {
                System.out.println("==================================");
                System.out.println("ENTER RACE DISTANCE BELOW:");
                System.out.println(" - 'races' for list of race distances");
                System.out.println(" - 'exit' to exit the program");
                System.out.println("==================================");

                strInputRaceDistance = scanMain.nextLine();
                strInputRaceDistance = strInputRaceDistance.replaceAll("\\s+", "");
                if (strInputRaceDistance.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program. Taking you back to the main menu...");
                    break;
                } else if (strInputRaceDistance.equalsIgnoreCase("races")) {
                    System.out.println("==================================");

                    StringBuilder sb = new StringBuilder();

                    int count = 0;

                    for (String key : raceDistances.keySet()) {
                        sb.append(key).append(", ");
                        count++;

                        if (count % 6 == 0) {
                            sb.setLength(sb.length() - 2);
                            sb.append("\n");
                        }
                    }

                    if (count % 6 != 0) {
                        sb.setLength(sb.length() - 2); // remove last ", "
                    }

                    System.out.println(sb);
                    System.out.println("==================================");
                    System.out.println();
                    continue;
                }

                if (!raceDistances.containsKey(strInputRaceDistance)) {
                    System.out.println("Not a valid race distance.");
                } else {

                    //while (true) {

                        System.out.println("Enter your race time:");
                        strInputRaceTime = scanMain.nextLine();

                        //while (true) {

                            System.out.println("Enter the race you want to convert to:");
                            convertRace = scanMain.nextLine();

                            if (!raceDistances.containsKey(convertRace)) {
                                System.out.println("Not a valid race distance.");
                            } else {

                                boolean isValidTime = true;

                                if (strInputRaceTime.contains(":")) {
                                    totalTime = strInputRaceTime.split(":");

                                    try {

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
                                            System.out.println("1. Invalid time format. Try HH:MM:SS");
                                            isValidTime = false;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("2. Invalid time format. Try HH:MM:SS");
                                        isValidTime = false;
                                    }
                                } else {
                                    try {
                                        dblTotalTime = Double.parseDouble(strInputRaceTime);
                                    } catch (NumberFormatException e) {
                                        System.out.println("3. Invalid time format. Try HH:MM:SS");

                                        isValidTime = false;
                                    }
                                }

                                if (isValidTime) {

                                    Calculations.calcPrint(strInputRaceDistance, strInputRaceTime, dblTotalTime);
                                    Calculations.convCalcPrint(strInputRaceDistance, strInputRaceTime, convertRace, resultScore);
                                }
                            }
                        //}
                    //}
                }
                System.out.println("Enter a new distance...\n");
            }
        } else {
            System.out.println("That is an invalid option. Please try again.");
        }
    }

}