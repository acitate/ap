package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_2
{
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

            }
        }

        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < d; j++)
            {
                if ((i == 0 || j == 0) || (i == k+1 || j == k+1))
                {
                    System.out.print(array[i][j]);
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
