import java.util.Scanner;
import static java.lang.Math.pow;

public class Exercise6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, temp;
        int num = 100;
        int even_sum = 0;
        int odd_sum = 0;
        int square_sum = 0;
        int sum = 0;


        for (int i = 2; i <= num; i += 2) {
            even_sum += i;
        }
        System.out.println("Sum of even numbers in [2, 100]: " + even_sum);


        for (int j = 1; j <= num; j++) {
            square_sum += pow(j, 2);
        }
        System.out.println("Sum of squares in [1, 100]: " + square_sum);


        for (int k = 0; k <= 20; k++) {
            System.out.printf("%.0f\t",pow(2, k));
        }
        System.out.println();


        a = sc.nextInt();
        b = sc.nextInt();
        if (a % 2 == 0) { a++; }
        if (b % 2 == 0) { b--; }

        for (int l = a; l <= b; l += 2) {
            odd_sum += l;
        }
        System.out.println(odd_sum);


        c = sc.nextInt();
        while (c != 0) {
            temp = c % 10;
            if (temp % 2 == 1) {
                sum += temp;
            }
            c = c / 10;
        }
        System.out.println(sum);
    }
}
