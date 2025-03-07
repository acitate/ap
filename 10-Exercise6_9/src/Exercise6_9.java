import java.util.ArrayList;
import java.util.Scanner;

public class Exercise6_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
//        ArrayList<Character> reversed_str = new ArrayList<>();
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
//            reversed_str.add(str.charAt(i));
            reversed += str.charAt(i);
        }

        System.out.println(reversed);
    }
}
