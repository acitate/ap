package ap.projects.mid_project;

import java.util.Scanner;

public class InputHandler {
    Scanner in = new Scanner(System.in);
    int choice;

    public int takeChoice(int limit) {
        choice = in.nextInt();
        while (choice > limit || choice < 0) {
            System.out.print("Invalid input, try again.\nChoice: ");
            choice = in.nextInt();
        }
        in.nextLine();
        return choice;
    }

    public String takeAlphabeticString(String message) {
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

    public String takeString(String message) {
        System.out.print(message);
        return in.nextLine();
    }
    
    public int takeInt(String message) {
        System.out.print(message);
        return in.nextInt();
    }

    public String takeNumericString(String message) {
        System.out.print(message);

        String input = in.nextLine().trim();
        while (!input.matches("[0-9]+")) {
            System.out.print("Invalid input, try again: ");
            input = in.nextLine().trim();
        }

        return input;
    }
}
