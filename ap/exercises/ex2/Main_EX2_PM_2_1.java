package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_1 {
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
        char direction;
        while (true)
        {
            direction = in.next().toLowerCase().charAt(0);
            switch (direction)
            {
                case ('w'):
                    System.out.println("w, up");
                    if (row - 1 == 0) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        row--;
                        array[row][col] = 'X';
                    }
                    break;
                case ('d'):
                    System.out.println("d, right");
                    if (col == k) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        col++;
                        array[row][col] = 'X';
                    }
                    break;
                case ('s'):
                    System.out.println("s, down");
                    if (row == k ) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        row++;
                        array[row][col] = 'X';
                    }
                    break;
                case ('a'):
                    System.out.println("a, left");
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

//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {}
        }
    }
}
