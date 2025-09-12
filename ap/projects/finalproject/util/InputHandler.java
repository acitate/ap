package ap.projects.finalproject.util;

import java.util.Scanner;

public class InputHandler {
    static Scanner in = new Scanner(System.in);

    public static int getChoice(int limit) {
        int choice = in.nextInt();
        while (choice > limit || choice < 0) {
            System.out.print("Invalid input, try again.\nChoice: ");
            choice = in.nextInt();
        }
        in.nextLine();
        return choice;
    }

    public static String getAlphabeticString(String message) {
        // takes an string of only english characters.
        System.out.print(message);
        String input;
        while (true) {
            input = in.nextLine().trim();

            if (input.matches("[A-Za-z]+")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter letters only (A-Z or a-z).");
            }
        }
    }

    public static String getString(String message) {
        System.out.print(message);
        return in.nextLine();
    }
    
    public static int getInt(String message) {
        System.out.print(message);
        return in.nextInt();
    }

    public static int getInt(String message, int min, int max) {
        // prints message and takes an integer between min and max
        System.out.printf(message);
        while (true) {
            try {
                int input = Integer.parseInt(in.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    public static String getNumericString(String message) {
        // prints message and takes a string composed entirely of digits
        System.out.print(message);

        String input = in.nextLine().trim();
        while (!input.matches("[0-9]+")) {
            System.out.print("Invalid input, try again: ");
            input = in.nextLine().trim();
        }

        return input;
    }
}
