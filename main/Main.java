package main;

import java.util.Scanner;
import paceconvert.PaceConvert;
import altitudeconversion.altitudeconversion;
import trainingpaces.trainingpaces;
import trainsuggest.trainsuggest;
import splitadd.splitadd;
import mileagetrack.mileagetrack;
import perfranking.perfranking;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("=================================================");
            System.out.println("\t\t\t\tWELCOME TO VO2day!");
            System.out.println("=================================================");
            System.out.println("1. paceconvert");
            System.out.println("2. altitudeconversion");
            System.out.println("3. trainingpaces");
            System.out.println("4. trainsuggest");
            System.out.println("5. splitadd");
            System.out.println("6. mileagetrack");
            System.out.println("7. perfranking");
            System.out.println("Which program would you like to run? (type 'exit' to quit): ");
            input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "paceconvert", "1":
                    PaceConvert.main(args);
                    break;
                case "altitudeconversion", "2":
                    altitudeconversion.main(args);
                    break;
                case "trainingpaces", "3":
                    trainingpaces.main(args);
                    break;
                case "trainsuggest", "4":
                    trainsuggest.main(args);
                    break;
                case "splitadd", "5":
                    splitadd.main(args);
                    break;
                case "mileagetrack", "6":
                    mileagetrack.main(args);
                    break;
                case "perfranking", "7":
                    perfranking.main(args);
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