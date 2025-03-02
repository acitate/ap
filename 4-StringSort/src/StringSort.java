import java.util.ArrayList;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> str_list = new ArrayList<>();
        ArrayList<String> sorted_list = new ArrayList<>();
        String whatever = "z";
        String temp1;
        String temp2;
        String temp3;

        for (int i = 1; i <= 3; i++) {
            str_list.add(input.next());
        }

        int size = str_list.size();

        for (int i = 0; i < size; i++) {
            for (int c1 = 0; c1 < str_list.size(); c1++) {
                for (int c2 = c1; c2 <= str_list.size(); c2++) {
                    if (c2 != c1 && c2 != str_list.size()) {
                        // if positive c1 is after c2 by output
                        // if negative c1 is ahead of c2 by output
                        temp1 = str_list.get(c1);
                        temp2 = str_list.get(c2);
                        temp3 = ((temp1.compareTo(temp2) < 0) ? temp1 : temp2);
                        whatever = ((whatever.compareTo(temp3) < 0) ? whatever : temp3);
                    }
                }
            }

            if (!sorted_list.contains(whatever)) {
                sorted_list.add(whatever);
                str_list.remove(whatever);
                whatever = "z";
            }

            if (str_list.size() == 1) {
                sorted_list.add(str_list.get(0));
                break;
            }
        }


        for (String str : sorted_list) {
            System.out.println(str);
        }
    }
}

