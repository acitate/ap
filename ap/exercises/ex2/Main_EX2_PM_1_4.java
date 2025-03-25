package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char c;

        while (true) {
            c = in.next().toLowerCase().charAt(0);

            switch (c) {
                case ('w'):
                    System.out.println("UP");
                    break;
                case ('a'):
                    System.out.println("LEFT");
                    break;

                case ('s'):
                    System.out.println("DOWN");
                    break;
                case ('d'):
                    System.out.println("RIGHT");
                    break;
                case ('q'):
                    System.out.println("EXIT");
                    break;
            }


        }
    }
}
