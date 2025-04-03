package ap.exercises.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {

    public static void displayArray(char[][] array) {
        for (char[] row : array) {
            for (char c : row) {

                System.out.print(c);
            }
            
            System.out.println("\t");
        }
    }

    public static void saveArray(char[][] array, FileWriter writer) {
        try {

            for (char[] row : array) {
                for (char c : row) {
                    writer.write(c);
                }

                writer.write("\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char[][] array = null;
        int k = 0, d = 0, points_num = 0, row = 0, col = 0, score = 0;
        FileWriter writer = null;
        Scanner reader = null;
        File save = null;
        long start = System.currentTimeMillis();

        try {
            save = new File("save.txt");

            if (save.createNewFile()) {

                System.out.println("Save not found, initiating new game...");
                writer = new FileWriter(save);
                k = in.nextInt();
                d = k + 2;
                array = new char[d][d];

                for (int i = 0; i < d; i++) {
                    for (int j = 0; j < d; j++) {

                        if ((i == 0 || j == 0) || (i == k + 1 || j == k + 1)) {
                            array[i][j] = '*';
                        } else {
                            array[i][j] = ' ';
                        }
                    }
                }


                points_num = in.nextInt();
                if (points_num > (k * k) - 1) {
                    System.out.println("Error");
                    points_num = in.nextInt();
                }

                Integer[] pair;
                ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();
                for (int i = 1; i <= k; i++) {
                    for (int j = 1; j <= k; j++) {
                        if (!(i == 1 && j == 1)) {
                            pair = new Integer[]{i, j};
                            pairs.add(pair);
                        }
                    }
                }
                Collections.shuffle(pairs);


                for (int i = 0; i < points_num; i++) {
                    pair = pairs.get(i);
                    array[pair[0]][pair[1]] = '.';

                }

                row = 1;
                col = 1;
                array[row][col] = 'X';
                start = System.currentTimeMillis();

            } else {
                reader = new Scanner(save);

                k = reader.nextInt();
                points_num = reader.nextInt();
                row = reader.nextInt();
                col = reader.nextInt();
                score = reader.nextInt();
                start = reader.nextLong();

                array = new char[k+2][k+2];
                String line = null;
                reader.nextLine();
                for (int i = 0; i < k+2; i++) {
                    line = reader.nextLine();
                    System.out.println(line);
                    array[i] = line.toCharArray();
                }

                System.out.println("Save loaded.");
            }

        } catch (IOException e) {
            System.out.println("Error");
            System.exit(1);
        }

        char direction;

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

                case ('q'):
                    try {
                        writer = new FileWriter(save);
                        writer.write(k + "\n" + points_num + "\n" + row + "\n" + col + "\n" + score + "\n" + start + "\n");
                    } catch (IOException e) {
                        System.out.println("IO error");
                    }
                    saveArray(array, writer);
                    System.exit(0);
            }


            displayArray(array);

            if (score == points_num) {
                save.delete(); 
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
