package ap.exercises.ex2;

import java.util.*;

public class Main_EX2_PM_1_3 {
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

        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < d; j++)
            {
                {
                    System.out.print(array[i][j]);
                }
            }
            System.out.print("\n");
        }


        int c = in.nextInt();
        if (c > (k*k))
        {
            System.out.println("Error");
            c = in.nextInt();
        }
        in.close();

        Integer[] pair;
        ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();
        for (int i = 1; i <= k; i++)
        {
            for (int j = 1; j <= k; j++)
            {
                pair = new Integer[]{i, j};
                pairs.add(pair);
            }
        }
        Collections.shuffle(pairs);

        for (int i = 0; i < c; i++)
        {
            pair = pairs.get(i);
            array[pair[0]][pair[1]] = '.';
        }

        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < d; j++)
            {
//                if ((i == 0 || j == 0) || (i == k+1 || j == k+1))
                {
                    System.out.print(array[i][j]);
                }
            }
            System.out.print("\n");
        }
    }
}
