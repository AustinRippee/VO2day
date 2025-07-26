package paceconvert;

public class Calculations {
    // Score = A * (D / T) - B
    // A = Scaling factor that adjusts for the distance
    // D = Distance in meters
    // T = time in seconds
    // B = baseline value to align the scale appropriately
    public static void calcPrint(String strInputRaceDistance, String strInputRaceTime, double dblTotalTime) {
        switch (strInputRaceDistance) {
            case "100m", "100":
                PaceConvert.resultScore = 290.52712 * (100 / dblTotalTime) - 1953.2266;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "150m", "150":
                PaceConvert.resultScore = 265.3031224 * (150 / dblTotalTime) - 1720.7734;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "200m", "200":
                PaceConvert.resultScore = 267.75893 * (200 / dblTotalTime) - 1703.6447;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "300m", "300":
                PaceConvert.resultScore = 251.7769577 * (300 / dblTotalTime) - 1414.90071;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "400m", "400":
                PaceConvert.resultScore = 262.37121 * (400 / dblTotalTime) - 1402.7708;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "600m", "600":
                PaceConvert.resultScore = 285.7637 * (600 / dblTotalTime) - 1371.563558;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "800m", "800":
                PaceConvert.resultScore = 302.9089 * (800 / dblTotalTime) - 1377.5673;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "1000m", "1000", "1,000", "1,000m", "1k", "1km":
                PaceConvert.resultScore = 313.6503268 * (1000 / dblTotalTime) - 1374.25166;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "1500m", "1500", "1,500", "1,500m", "1.5k", "1.5km":
                PaceConvert.resultScore = 320.6038 * (1500 / dblTotalTime) - 1314.0045;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "1600m", "1600", "1,600", "1,600m", "1.6k", "1.6km":
                //            v this value is probably wrong
                PaceConvert.resultScore = 321.7731201 * (1600 / dblTotalTime) - 1306.325127;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "1 Mile", "1Mile", "Mile", "One Mile", "1609", "1609m", "1 mile", "1mile", "1mi", "mile",
                 "one mile", "One mile", "one Mile":
                PaceConvert.resultScore = 321.7731201 * (1609.34 / dblTotalTime) - 1306.285127;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "2000m", "2000", "2,000", "2,000m", "2k":
                PaceConvert.resultScore = 328.2988442 * (2000 / dblTotalTime) - 1303.430804;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "3000m", "3000", "3,000", "3,000m", "3k":
                PaceConvert.resultScore = 331.264214 * (3000 / dblTotalTime) - 1240.294895;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "3200m", "3200", "3,200", "3,200m":
                //            v this value is probably wrong
                PaceConvert.resultScore = 333.4505158 * (2 * 1600 / dblTotalTime) - 1241.705275;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "2 Mile", "2 Miles", "2Mile", "2Miles", "Two Miles", "Two Mile", "3218", "3218m", "2mi", "2MI",
                 "2Mi":
                PaceConvert.resultScore = 333.4505158 * (2 * 1609.34 / dblTotalTime) - 1241.705275;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "5000m", "5,000m", "5000", "5,000", "5k", "5km":
                PaceConvert.resultScore = 342.8535 * (5000 / dblTotalTime) - 1234.1959;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "6000m", "6,000m", "6000", "6,000", "6k", "6km":
                PaceConvert.resultScore = 344.0777994 * (6000 / dblTotalTime) - 1217.284313;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "8000m", "8,000m", "8000", "8,000", "8k", "8km":
                PaceConvert.resultScore = 348.6258257 * (8000 / dblTotalTime) - 1192.426848;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "10000m", "10,000m", "10000", "10,000", "10k", "10km":
                PaceConvert.resultScore = 349.8535 * (10000 / dblTotalTime) - 1171.2847;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "10 Miles", "10mi":
                PaceConvert.resultScore = 360.6890152 * (10 * 1609.34 / dblTotalTime) - 1164.451907;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "HalfM", "Half Marathon", "HM", "Half", "13.1", "13.1mi", "13.1 Miles":
                PaceConvert.resultScore = 366.3739581 * ((42194.99 / 2) / dblTotalTime) - 1168.783894;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            case "Marathon", "M", "Full Marathon", "Full", "Mara", "26.2", "26.2mi", "26.2 Miles":
                PaceConvert.resultScore = 384.5408 * (42194.99 / dblTotalTime) - 1161.8021;
                System.out.println("========================");
                System.out.println("Distance Entered: " + strInputRaceDistance);
                System.out.println("Time Entered: " + strInputRaceTime);
                System.out.println("========================");
                break;
            default:
                if (dblTotalTime == 0.0) {
                    System.out.println("Invalid time format. Please try again.");
                } else {
                    System.out.println("That is not a valid race distance.");
                }
                break;
        }
    }

    public static void convCalcPrint(String strInputRaceDistance, String strInputRaceTime, String convertRace,double resultScore) {
        double dblConvHr, dblConvMin, dblConvSec;
        int intConvMin, intConvHr;
        String strConvSec;

        switch (convertRace) {
            case "100m", "100":
                dblConvSec = 100 / (0.003439 * resultScore + 6.72526);
                intConvMin = 0;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "150m", "150":
                dblConvSec = 150 / (.003768768 * resultScore + 6.486427968);
                intConvMin = 0;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "200m", "200":
                dblConvSec = 200 / (0.003734 * resultScore + 6.36315);
                intConvMin = 0;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "300m", "300":
                dblConvSec = 300 / (0.003970935 * resultScore + 5.620258201);
                intConvMin = 0;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "400m", "400":
                dblConvSec = 400 / (0.0038105 * resultScore + 5.34719);
                intConvMin = 0;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "600m", "600":
                dblConvMin = Math.round(Math.floor(600 / (0.003499 * resultScore + 4.80022) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((600 / (0.003499 * resultScore + 4.80022) / 60) - intConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "800m", "800":
                dblConvMin = Math.round(Math.floor(800 / (0.003300 * resultScore + 4.54844) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((800 / (0.003300 * resultScore + 4.54844) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "1000m", "1000", "1,000", "1,000m", "1k", "1km":
                dblConvMin = Math.round(Math.floor(1000 / (0.00318746 * resultScore + 4.382052887) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((1000 / (0.00318746 * resultScore + 4.382052887) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "1500m", "1500", "1,500", "1,500m", "1.5k", "1.5km":
                dblConvMin = Math.round(Math.floor(1500 / (0.003117 * resultScore + 4.09988) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((1500 / (0.003117 * resultScore + 4.09988) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "1600m", "1600", "1,600", "1,600m":
                break;
            case "1mi", "1 Mile", "1Mile", "Mile", "One Mile", "1609", "1609m":
                dblConvMin = Math.round(Math.floor(1609.34 / (0.0031062 * resultScore + 4.060811045) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((1609.34 / (0.0031062 * resultScore + 4.060811045) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "2000m", "2000", "2,000", "2,000m":
                dblConvMin = Math.round(Math.floor(2000 / (0.0030444 * resultScore + 3.97139601) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((2000 / (0.0030444 * resultScore + 3.97139601) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "3000m", "3000", "3,000", "3,000m", "3k":
                dblConvMin = Math.round(Math.floor(3000 / (0.0030147 * resultScore + 3.74703401) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((3000 / (0.0030147 * resultScore + 3.74703401) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "3200m", "3200", "3,200", "3,200m":
                intConvMin = 0;
                strConvSec = "";
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "2 Mile", "2 Miles", "2Mile", "2Miles", "Two Miles", "Two Mile", "3218", "3218m", "2mi", "2Mi",
                 "2MI":
                dblConvMin = Math.round(Math.floor(2 * 1609.34 / (0.0029949 * resultScore + 3.726724) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((2 * 1609.34 / (0.0029949 * resultScore + 3.726724) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "5000m", "5,000m", "5000", "5,000", "5k", "5km":
                dblConvMin = Math.round(Math.floor(5000 / (0.0029129 * resultScore + 3.602496) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((5000 / (0.0029129 * resultScore + 3.602496) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "6000m", "6,000m", "6000", "6,000", "6k", "6km":
                dblConvMin = Math.round(Math.floor(6000 / (0.0029028 * resultScore + 3.5403469) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((6000 / (0.0029028 * resultScore + 3.5403469) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "8000m", "8,000m", "8000", "8,000", "8k", "8km":
                dblConvMin = Math.round(Math.floor(8000 / (0.0028672 * resultScore + 3.4212486) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((8000 / (0.0028672 * resultScore + 3.4212486) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "10000m", "10,000m", "10000", "10,000", "10k", "10km":
                dblConvMin = Math.round(Math.floor(10000 / (0.002857 * resultScore + 3.348169) / 60));
                intConvMin = (int) dblConvMin;
                dblConvSec = ((10000 / (0.002857 * resultScore + 3.348169) / 60) - dblConvMin) * 60;
                strConvSec = String.format("%05.2f", dblConvSec);
                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvMin, strConvSec);
                break;
            case "10 Miles", "10mi":
                dblConvHr = Math.floor(16093.4 / (0.0027716 * resultScore + 3.2290278) / 3600);
                dblConvMin = Math.floor(((16093.4 / (0.0027716 * resultScore + 3.2290278) / 3600) - dblConvHr) * 60);
                dblConvSec = ((((16093.4 / (0.0027716 * resultScore + 3.2290278) / 3600) - dblConvHr) * 60) - dblConvMin) * 60;

                intConvHr = (int) dblConvHr;
                intConvMin = (int) dblConvMin;

                strConvSec = String.format("%05.2f", dblConvSec);

                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvHr, intConvMin, strConvSec);
                break;
            case "HalfM", "Half Marathon", "HM", "Half", "13.1", "13.1mi", "13.1 Miles":
                double halfDistance = 42194.99 / 2;
                dblConvHr = Math.floor(halfDistance / (0.0026921 * resultScore + 3.098524) / 3600);
                dblConvMin = Math.floor(((halfDistance / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60);
                dblConvSec = ((((halfDistance / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60) - dblConvMin) * 60;

                intConvHr = (int) dblConvHr;
                intConvMin = (int) dblConvMin;

                strConvSec = String.format("%05.2f", dblConvSec);

                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvHr, intConvMin, strConvSec);
                break;
            case "Marathon", "M", "Full Marathon", "Full", "Mara", "26.2", "26.2mi", "26.2 Miles":
                dblConvHr = Math.floor(42194.99 / (0.0026921 * resultScore + 3.098524) / 3600);
                dblConvMin = Math.floor(((42194.99 / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60);
                dblConvSec = ((((42194.99 / (0.0026921 * resultScore + 3.098524) / 3600) - dblConvHr) * 60) - dblConvMin) * 60;

                intConvHr = (int) dblConvHr;
                intConvMin = (int) dblConvMin;

                strConvSec = String.format("%05.2f", dblConvSec);

                PrintUI.raceOutput(strInputRaceDistance, strInputRaceTime, convertRace, intConvHr, intConvMin, strConvSec);
                break;
            default:
                System.out.println("Invalid race distance. Please try again.");
        }
    }
}
