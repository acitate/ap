import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;

public class Exercise6_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        int temp_in = in.nextInt();

        while(temp_in != -9999) {
            array.add(temp_in);
            temp_in = in.nextInt();
        }

        int maximum = array.get(0), minimum = array.get(0);
        int culm_sum = 0;
        int odd_count = 0, even_count = 0;

        for (Integer integer : array) {
            maximum = (integer > maximum) ? integer : maximum;
            minimum = (integer < minimum) ? integer : minimum;


            if (integer % 2 == 0) {
                even_count++;
            } else {
                odd_count++;
            }


            culm_sum += integer;
            System.out.printf("%d\t", culm_sum);
//            System.out.println(array.stream().allMatch(2));
        }
        System.out.printf("\nMaximum = %d \nMinimum = %d\n", maximum, minimum);
        System.out.printf("Odd count = %d\nEven Count = %d\n", odd_count, even_count);


        for (int i = 0; i < array.size(); i++) {
            if (i != 0 && array.get(i).equals(array.get(i-1))) {
                System.out.println(array.get(i));
            }
        }
        }
    }

