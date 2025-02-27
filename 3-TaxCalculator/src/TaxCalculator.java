import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double income = input.nextDouble();
        double tax = 0;

        if (income >= 50000) {
            income -= 50000;
            tax += 50000 * 0.01;
        } else {
            tax += income * 0.01;
            income = 0;
        }

        if (income >= 25000) {
            income -= 25000;
            tax += 25000 * 0.02;
        } else {
            tax += income * 0.02;
            income = 0;
        }

        if (income >= 25000) {
            income -= 25000;
            tax += 25000 * 0.03;
        } else {
            tax += income * 0.03;
            income = 0;
        }

        if (income >= 150000) {
            income -= 150000;
            tax += 150000 * 0.04;
        } else {
            tax += income * 0.04;
            income = 0;
        }

        if (income >= 250000) {
            income -= 250000;
            tax += income * 0.05;
        } else {
            tax += income * 0.05;
            income = 0;
        }

        if (income > 0) {
            tax += income * 0.06;
        }

        System.out.println(tax);
    }
}
