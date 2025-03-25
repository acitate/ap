package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_5 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();

        int d = k+2;
        char[][] array = new char[d][d];

        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < d; j++)
            {
                if ((i == 0 || j == 0) || (i == k+1 || j == k+1))
                {
                    array[i][j] = '*';
                }
                else
                {
                    array[i][j] = ' ';
                }

            }
        }

        int row = 1, col = 1;
        array[row][col] = 'X';
        Random rand = new Random();
        int direction;
        while (true)
        {
            direction = rand.nextInt(4);
            switch (direction)
            {
                case (0):
                    System.out.println("0, up");
                    if (row - 1 == 0) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        row--;
                        array[row][col] = 'X';
                    }
                    break;
                case (1):
                    System.out.println("1, right");
                    if (col == k) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        col++;
                        array[row][col] = 'X';
                    }
                    break;
                case (2):
                    System.out.println("2, down");
                    if (row == k ) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        row++;
                        array[row][col] = 'X';
                    }
                    break;
                case (3):
                    System.out.println("3, left");
                    if (col - 1 == 0) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        col--;
                        array[row][col] = 'X';
                    }
                    break;
            }

            for (int i = 0; i < d; i++)
            {
                for (int j = 0; j < d; j++)
                {

                    System.out.print(array[i][j]);

                }
                System.out.print("\n");
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
