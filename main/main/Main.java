package main;

import java.util.Scanner;

import pacecalculator.PaceCalculator;
import paceconvert.PaceConvert;
import trainingpaces.TrainingPaces;
import altitudeconvert.AltitudeConvert;
import mileagetracker.MileageTracker;
import perfranking.PerfRanking;
import splitadder.SplitAdder;
import trackconvert.TrackConvert;
import trainingsuggestions.TrainingSuggestions;
import windconvert.WindConvert;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("=================================================");
            System.out.println("\t\t\t\tWELCOME TO Vo2sDay!");
            System.out.println("\t\t\t Written by Austin Rippee");
            System.out.println("=================================================");
            System.out.println("1. paceconvert");
            System.out.println("2. altitudeconversion");
            System.out.println("3. trainingpaces");
            System.out.println("4. trainingsuggestions");
            System.out.println("5. splitadd");
            System.out.println("6. mileagetracker");
            System.out.println("7. perfranking");
            System.out.println("8. pacecalculator");
            System.out.println("9. trackconvert");
            System.out.println("10. windconvert");
            System.out.println("Which program would you like to run? (type 'exit' to quit): ");
            input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "paceconvert", "1":
                    PaceConvert.main(args);
                    break;
                case "altitudeconversion", "2":
                    AltitudeConvert.main(args);
                    break;
                case "trainingpaces", "3":
                    TrainingPaces.main(args);
                    break;
                case "trainingsuggestions", "4":
                    TrainingSuggestions.main(args);
                    break;
                case "splitadd", "5":
                    SplitAdder.main(args);
                    break;
                case "mileagetracker", "6":
                    MileageTracker.main(args);
                    break;
                case "perfranking", "7":
                    PerfRanking.main(args);
                    break;
                case "pacecalculator", "8":
                    PaceCalculator.main(args);
                    break;
                case "trackconvert", "9":
                    TrackConvert.main(args);
                    break;
                case "windconvert", "10":
                    WindConvert.main(args);
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Unknown command. Try again.");
            }
        }
    }
}