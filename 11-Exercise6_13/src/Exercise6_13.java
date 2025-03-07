import java.util.ArrayList;
import java.util.Scanner;

public class Exercise6_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();
        int remainder;
        ArrayList<Integer> binary = new ArrayList<>();

        while (number != 0) {
            remainder = number % 2;
            number /= 2;
            binary.add(remainder);
        }

        for (int i = 0; i <= binary.size() - 1; i++) {
            System.out.println(binary.get(i));
        }
    }
}
