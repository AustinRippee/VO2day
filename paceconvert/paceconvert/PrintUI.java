package paceconvert;

public class PrintUI {
    public static void introPrompt() {
        System.out.println("========================================");
        System.out.println("\t\t\t\t******");
        System.out.println("\t\t\tPaceConvert");
        System.out.println("\t\tWritten by: Austin Rippee");
        System.out.println("\t\t\t\t******");
        System.out.println("========================================");
    }

    public static void fileIntroPrompt() {
        System.out.println("Format for CSV file:");
        System.out.println("==========================================");
        System.out.println("Column A\tColumn B\tColumn C");
        System.out.println("Distance\tTime\t\tConverted Distance");
        System.out.println("800m\t\t1:53.82\t\t1 Mile");
        System.out.println("==========================================");
        //System.out.println("Please upload the file you would like:");
    }

    public static void raceOutput(String inputRaceDistance, String strInputRaceTime, String convertRace,
                           int comp_m_int, String comp_s_s) {
        System.out.println("=======================================================================");
        System.out.println();
        System.out.println("Converted Time from " + inputRaceDistance + " (" + strInputRaceTime + ") to " + convertRace + ": "
                + String.format("%02d", comp_m_int) + ":" + comp_s_s);
        System.out.println();
        System.out.println("=======================================================================");
    }

    public static void raceOutput(String inputRaceDistance, String strInputRaceTime, String convertRace,
                           int comp_h_int, int comp_m_int, String comp_s_s) {
        System.out.println("=======================================================================");
        System.out.println();
        System.out.println("Converted Time from " + inputRaceDistance + " (" + strInputRaceTime + ") to " + convertRace + ": "
                + comp_h_int + ":" + String.format("%02d", comp_m_int) + ":" + comp_s_s);
        System.out.println();
        System.out.println("=======================================================================");
    }
}
