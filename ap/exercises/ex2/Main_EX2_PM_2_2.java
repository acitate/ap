package ap.exercises.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_EX2_PM_2_2 {
    public static void main(String[] args) {
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


        int points_num = in.nextInt();
        if (points_num > (k*k) - 1)
        {
            System.out.println("Error");
            points_num = in.nextInt();
        }

        Integer[] pair;
        ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();
        for (int i = 1; i <= k; i++)
        {
            for (int j = 1; j <= k; j++)
            {
                if (!(i == 1 && j == 1)) {
                    pair = new Integer[]{i, j};
                    pairs.add(pair);
                }
            }
        }
        Collections.shuffle(pairs);


        for (int i = 0; i < points_num; i++)
        {
            pair = pairs.get(i);
            array[pair[0]][pair[1]] = '.';
        }

        int row = 1, col = 1;
        int score = 0;
        array[row][col] = 'X';
        char direction;
        long start = System.currentTimeMillis();

        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < d; j++)
            {

                System.out.print(array[i][j]);

            }
            System.out.print("\n");
        }

        while (true) {
            direction = in.next().toLowerCase().charAt(0);
            switch (direction) {
                case ('w'):
                    System.out.println("w, up");
                    if (row - 1 == 0) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        row--;
                        score = (array[row][col] == '.') ? score + 1: score;
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
                        score = (array[row][col] == '.') ? score + 1: score;
                        array[row][col] = 'X';
                    }
                    break;
                case ('s'):
                    System.out.println("s, down");
                    if (row == k) {
                        System.out.println("hitting the game wall");
                    } else {
                        array[row][col] = ' ';
                        row++;
                        score = (array[row][col] == '.') ? score + 1: score;
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
                        score = (array[row][col] == '.') ? score + 1: score;
                        array[row][col] = 'X';
                    }
                    break;
            }


            for (int i = 0; i < d; i++) {
                for (int j = 0; j < d; j++) {

                    System.out.print(array[i][j]);

                }
                System.out.print("\n");
            }
            if (score == points_num) {
                break;
            }
        }
        in.close();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Score: " + score);
        System.out.println("Time elapsed: " + timeElapsed / 1000 + "s");

    }
}
