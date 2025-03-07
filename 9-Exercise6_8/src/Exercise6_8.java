import java.util.Scanner;

public class Exercise6_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
//        char[] chars = input.;
        for (char c : input.toCharArray()) {
            System.out.println(c);
        }
    }
}
