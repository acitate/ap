import java.util.Scanner;
import static java.lang.Math.abs;

public class FloatCheck {
    public static void main(String[] args) {
        String output = "";
        Scanner input = new Scanner(System.in);
        float input_number = input.nextFloat();


        if (abs(input_number) < 1 && input_number != 0) {
            output += "small ";
        } else if (abs(input_number) > 1000000) {
            output += "large ";
        }

        if (input_number == 0) {
            output += "Zero";
        } else if (input_number > 0) {
            output += "positive";
        } else {
            output += "negative";
        }

        System.out.println(output);
    }
}
