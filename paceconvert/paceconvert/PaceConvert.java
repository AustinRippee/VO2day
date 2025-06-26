package paceconvert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.midi.SysexMessage;
import javax.swing.JFileChooser;

public class PaceConvert {
    public static void main(String[] args) {

        ArrayList<String> raceDistances = new ArrayList<>(Arrays.asList(
                "1000m", "1000", "1,000", "1,000m", "1k", "1km", "100m", "100", "150m", "150",
                "200m", "200", "300m", "300", "400m", "400", "600m", "600", "800m", "800",
                "1500m", "1500", "1,500", "1,500m", "1.5k", "1.5km", "1600m", "1600", "1,600",
                "1,600m", "1.6k", "1.6km", "1 Mile", "1Mile", "Mile", "One Mile", "1609",
                "1609m", "1 mile", "1mile", "one mile", "One mile", "one Mile", "2000m",
                "2000", "2,000", "2,000m", "3000m", "3000", "3,000", "3,000m", "3200m",
                "3200", "3,200", "3,200m", "2 Mile", "2 Miles", "2Mile", "2Miles", "Two Miles",
                "Two Mile", "3218", "3218m", "5000m", "5,000m", "5000", "5,000", "5k", "5km",
                "6000m", "6,000m", "6000", "6,000", "6k", "6km", "8000m", "8,000m", "8000",
                "8,000", "8k", "8km", "10000m", "10,000m", "10000", "10,000", "10k", "10km",
                "10 Miles", "10mi", "Half Marathon", "HM", "Half", "13.1", "13.1mi",
                "13.1 Miles", "Marathon", "M", "Full Marathon", "Full", "Mara", "26.2",
                "26.2mi", "26.2 Miles"
        ));

        DecimalFormat df_obj = new DecimalFormat("#.##");
        double dblTotalTime = 0.0, resultScore = 0.0, dblTimeMin, dblTimeHr, dblTimeSec, dblConvHr, dblConvMin, dblConvSec;
        int intConvMin, intConvHr;
        Scanner scanMain;
        String strInputRaceDistance, strInputRaceTime, timeHr, timeMin, timeSec, convertRace, strConvSec;
        String[] totalTime;
        scanMain = new Scanner(System.in);

        introPrompt();

        System.out.println("Would you like to upload a file? (y/n)");
        String fileInput = scanMain.nextLine();

        if (fileInput.equalsIgnoreCase("y")) {
            fileIntroPrompt();
        } else if (fileInput.equalsIgnoreCase("n")) {
            while (true) {


                System.out.println("Enter your race distance (or type 'exit' to exit the program):");
                strInputRaceDistance = scanMain.nextLine();
                if (strInputRaceDistance.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program. Taking you back to the main menu...");
                    break;
                }

                if (!raceDistances.contains(strInputRaceDistance)) {
                    System.out.println("Not a valid race distance.");
                    break;
                } else {

                    System.out.println("Enter your race time:");
                    strInputRaceTime = scanMain.nextLine();

                    System.out.println("Enter the race you want to convert to:");
                    convertRace = scanMain.nextLine();

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
                                System.out.println("Invalid time format. Try HH:MM:SS");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid time format. Try HH:MM:SS");
                        }
                    } else {
                        try {
                            dblTotalTime = Double.parseDouble(strInputRaceTime);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid time format. Try HH:MM:SS");
                        }
                    }

                    // Score = A * (D / T) - B
                    // A = Scaling factor that adjusts for the distance
                    // D = Distance in meters
                    // T = time in seconds
                    // B = baseline value to align the scale appropriately
                    switch (strInputRaceDistance) {
                        case "100m", "100":
                            resultScore = 290.52712 * (100 / dblTotalTime) - 1953.2266;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "150m", "150":
                            resultScore = 265.3031224 * (150 / dblTotalTime) - 1720.7734;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "200m", "200":
                            resultScore = 267.75893 * (200 / dblTotalTime) - 1703.6447;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "300m", "300":
                            resultScore = 251.7769577 * (300 / dblTotalTime) - 1414.90071;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "400m", "400":
                            resultScore = 262.37121 * (400 / dblTotalTime) - 1402.7708;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "600m", "600":
                            resultScore = 285.7637 * (600 / dblTotalTime) - 1371.563558;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "800m", "800":
                            resultScore = 302.9089 * (800 / dblTotalTime) - 1377.5673;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "1000m", "1000", "1,000", "1,000m", "1k", "1km":
                            resultScore = 313.6503268 * (1000 / dblTotalTime) - 1374.25166;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "1500m", "1500", "1,500", "1,500m", "1.5k", "1.5km":
                            resultScore = 320.6038 * (1500 / dblTotalTime) - 1314.0045;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "1600m", "1600", "1,600", "1,600m", "1.6k", "1.6km":
                            resultScore = 321.7731201 * (1600 / dblTotalTime) - 1306.285127;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "1 Mile", "1Mile", "Mile", "One Mile", "1609", "1609m", "1 mile", "1mile", "1mi", "mile",
                             "one mile", "One mile", "one Mile":
                            resultScore = 321.7731201 * (1609.34 / dblTotalTime) - 1306.285127;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "2000m", "2000", "2,000", "2,000m":
                            resultScore = 328.2988442 * (2000 / dblTotalTime) - 1303.430804;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "3000m", "3000", "3,000", "3,000m":
                            resultScore = 331.264214 * (3000 / dblTotalTime) - 1240.294895;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "3200m", "3200", "3,200", "3,200m":
                            resultScore = 333.4505158 * (2 * 1600 / dblTotalTime) - 1241.705275;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "2 Mile", "2 Miles", "2Mile", "2Miles", "Two Miles", "Two Mile", "3218", "3218m":
                            resultScore = 333.4505158 * (2 * 1609.34 / dblTotalTime) - 1241.705275;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "5000m", "5,000m", "5000", "5,000", "5k", "5km":
                            resultScore = 342.8535 * (5000 / dblTotalTime) - 1234.1959;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "6000m", "6,000m", "6000", "6,000", "6k", "6km":
                            resultScore = 344.0777994 * (6000 / dblTotalTime) - 1217.284313;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "8000m", "8,000m", "8000", "8,000", "8k", "8km":
                            resultScore = 348.6258257 * (8000 / dblTotalTime) - 1192.426848;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "10000m", "10,000m", "10000", "10,000", "10k", "10km":
                            resultScore = 349.8535 * (10000 / dblTotalTime) - 1171.2847;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "10 Miles", "10mi":
                            resultScore = 360.6890152 * (10 * 1609.34 / dblTotalTime) - 1164.451907;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "Half Marathon", "HM", "Half", "13.1", "13.1mi", "13.1 Miles":
                            resultScore = 366.3739581 * (42194.99 / 2 / dblTotalTime) - 1168.783894;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        case "Marathon", "M", "Full Marathon", "Full", "Mara", "26.2", "26.2mi", "26.2 Miles":
                            resultScore = 384.5408 * (42194.99 / dblTotalTime) - 1161.8021;
                            printInfo(strInputRaceTime, strInputRaceDistance, resultScore);
                            break;
                        default:
                            if (dblTotalTime == 0.0) {
                                System.out.println("Invalid time format. Please try again.");
                            } else {
                                System.out.println("That is not a valid race distance.");
                                return;
                            }
                    }

                    switch (convertRace) {
                        case "100m", "100":
                            dblConvSec = 100 / (0.003439 * resultScore + 6.72526);
                            intConvMin = 0;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "150m", "150":
                            dblConvSec = 150 / (.003768768 * resultScore + 6.486427968);
                            intConvMin = 0;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "200m", "200":
                            dblConvSec = 200 / (0.003734 * resultScore + 6.36315);
                            intConvMin = 0;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "300m", "300":
                            dblConvSec = 300 / (0.003970935 * resultScore + 5.620258201);
                            intConvMin = 0;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "400m", "400":
                            dblConvSec = 400 / (0.0038105 * resultScore + 5.34719);
                            intConvMin = 0;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "600m", "600":
                            dblConvMin = Math.round(Math.floor(600 / (0.003499 * resultScore + 4.80022) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((600 / (0.003499 * resultScore + 4.80022) / 60) - intConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "800m", "800":
                            dblConvMin = Math.round(Math.floor(800 / (0.003300 * resultScore + 4.54844) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((800 / (0.003300 * resultScore + 4.54844) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "1000m", "1000", "1,000", "1,000m", "1k", "1km":
                            dblConvMin = Math.round(Math.floor(1000 / (0.00318746 * resultScore + 4.382052887) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((1000 / (0.00318746 * resultScore + 4.382052887) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "1500m", "1500", "1,500", "1,500m", "1.5k", "1.5km":
                            dblConvMin = Math.round(Math.floor(1500 / (0.003117 * resultScore + 4.09988) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((1500 / (0.003117 * resultScore + 4.09988) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "1600m", "1600", "1,600", "1,600m":
                            break;
                        case "1 Mile", "1Mile", "Mile", "One Mile", "1609", "1609m":
                            dblConvMin = Math.round(Math.floor(1609.34 / (0.0031062 * resultScore + 4.060811045) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((1609.34 / (0.0031062 * resultScore + 4.060811045) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "2000m", "2000", "2,000", "2,000m":
                            dblConvMin = Math.round(Math.floor(2000 / (0.0030444 * resultScore + 3.97139601) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((2000 / (0.0030444 * resultScore + 3.97139601) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "3000m", "3000", "3,000", "3,000m":
                            dblConvMin = Math.round(Math.floor(3000 / (0.0030147 * resultScore + 3.74703401) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((3000 / (0.0030147 * resultScore + 3.74703401) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "3200m", "3200", "3,200", "3,200m":
                            break;
                        case "2 Mile", "2 Miles", "2Mile", "2Miles", "Two Miles", "Two Mile", "3218", "3218m":
                            dblConvMin = Math.round(Math.floor(2 * 1609.34 / (0.0029949 * resultScore + 3.726724) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((2 * 1609.34 / (0.0029949 * resultScore + 3.726724) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "5000m", "5,000m", "5000", "5,000", "5k", "5km":
                            dblConvMin = Math.round(Math.floor(5000 / (0.0029129 * resultScore + 3.602496) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((5000 / (0.0029129 * resultScore + 3.602496) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "6000m", "6,000m", "6000", "6,000", "6k", "6km":
                            dblConvMin = Math.round(Math.floor(6000 / (0.0029028 * resultScore + 3.5403469) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((6000 / (0.0029028 * resultScore + 3.5403469) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "8000m", "8,000m", "8000", "8,000", "8k", "8km":
                            dblConvMin = Math.round(Math.floor(8000 / (0.0028672 * resultScore + 3.4212486) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((8000 / (0.0028672 * resultScore + 3.4212486) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "10000m", "10,000m", "10000", "10,000", "10k", "10km":
                            dblConvMin = Math.round(Math.floor(10000 / (0.002857 * resultScore + 3.348169) / 60));
                            intConvMin = (int) dblConvMin;
                            dblConvSec = ((10000 / (0.002857 * resultScore + 3.348169) / 60) - dblConvMin) * 60;
                            strConvSec = String.format("%05.2f", dblConvSec);
                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                            break;
                        case "10 Miles", "10mi":
                            dblConvHr = Math.floor(16093.4 / (0.0027716 * resultScore + 3.2290278) / 3600);
                            dblConvMin = Math.floor(((16093.4 / (0.0027716 * resultScore + 3.2290278) / 3600) - dblConvHr) * 60);
                            dblConvSec = ((((16093.4 / (0.0027716 * resultScore + 3.2290278) / 3600) - dblConvHr) * 60) - dblConvMin) * 60;

                            intConvHr = (int) dblConvHr;
                            intConvMin = (int) dblConvMin;

                            strConvSec = String.format("%05.2f", dblConvSec);

                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvHr, intConvMin, strConvSec);
                            break;
                        case "Half Marathon", "HM", "Half", "13.1", "13.1mi", "13.1 Miles":
                            double halfDistance = 42194.99 / 2;
                            dblConvHr = Math.floor(halfDistance / (0.0026921 * resultScore + 3.098524) / 3600);
                            dblConvMin = Math.floor(((halfDistance / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60);
                            dblConvSec = ((((halfDistance / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60) - dblConvMin) * 60;

                            intConvHr = (int) dblConvHr;
                            intConvMin = (int) dblConvMin;

                            strConvSec = String.format("%05.2f", dblConvSec);

                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvHr, intConvMin, strConvSec);
                            break;
                        case "Marathon", "M", "Full Marathon", "Full", "Mara", "26.2", "26.2mi", "26.2 Miles":
                            dblConvHr = Math.floor(42194.99 / (0.0026921 * resultScore + 3.098524) / 3600);
                            dblConvMin = Math.floor(((42194.99 / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60);
                            dblConvSec = ((((42194.99 / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60) - dblConvMin) * 60;

                            intConvHr = (int) dblConvHr;
                            intConvMin = (int) dblConvMin;

                            strConvSec = String.format("%05.2f", dblConvSec);

                            raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvHr, intConvMin, strConvSec);
                            break;
                        default:
                            System.out.println("Invalid race distance. Please try again.");
                    }
                }
                System.out.println("Enter a new distance...\n");
            }
        } else {
            System.out.println("That is an invalid option. Please try again.");
        }
    }

    static void printInfo(String strInputRaceTime, String strInputRaceDistance, double resultScore) {
        System.out.println("Time: " + strInputRaceTime);
        System.out.println("Distance: " + strInputRaceDistance);
        System.out.println("Score: " + resultScore);
    }

    static void raceOutput(String inputRaceDistance, String strInputRaceTime, String convertRace, int comp_m_int, String comp_s_s) {
        System.out.println("=======================================================================");
        System.out.println();
        System.out.println("Converted Time from " + inputRaceDistance + " (" + strInputRaceTime + ") to " + convertRace + ": "
                + String.format("%02d", comp_m_int) + ":" + comp_s_s);
        System.out.println();
        System.out.println("=======================================================================");
    }

    static void raceOutput(String inputRaceDistance, String strInputRaceTime, String convertRace, int comp_h_int, int comp_m_int, String comp_s_s) {
        System.out.println("=======================================================================");
        System.out.println();
        System.out.println("Converted Time from " + inputRaceDistance + " (" + strInputRaceTime + ") to " + convertRace + ": "
                + comp_h_int + ":" + String.format("%02d", comp_m_int) + ":" + comp_s_s);
        System.out.println();
        System.out.println("=======================================================================");
    }

    static void introPrompt() {
        System.out.println("========================================");
        System.out.println("\t\t\t\t******");
        System.out.println("\t\t\tPaceConvert");
        System.out.println("\t\tWritten by: Austin Rippee");
        System.out.println("\t\t\t\t******");
        System.out.println("========================================");
    }

    static void fileIntroPrompt(){
        System.out.println("Format for the CSV file:");
        System.out.println("==========================================");
        System.out.println("Column A\tColumn B\tColumn C");
        System.out.println("Distance\tTime\t\tConverted Distance");
        System.out.println("==========================================");
        System.out.println("Example:");
        System.out.println("800\t\t1:53.82\t\tMile");
        System.out.println("==========================================");
        System.out.println("Please upload the file you would like:");
    }
}