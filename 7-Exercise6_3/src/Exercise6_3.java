import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class Exercise6_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "Something Something DArk Soul";
        int vowel_count = 0;


        allUpper(str);
        allSecond(str);
        System.out.println(replaceVowels(str));

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (isVowel(tmp)) {
                vowel_count++;
                System.out.println(i);
            }
        }
        System.out.println(vowel_count);


    }

    static boolean isVowel(char chr) {
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');

        return vowels.contains(toLowerCase(chr));
    }


    static void allUpper(String str) {
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (isUpperCase(tmp)) {
                System.out.printf("%c\t", tmp);
            }
        }
        System.out.print("\n");
    }


    static void allSecond(String str) {
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (i % 2 == 1) {
                System.out.printf("%c\t", tmp);
            }
        }
        System.out.print("\n");
    }


    static String replaceVowels(String str) {
        String new_str = str.replaceAll("[aeioAEIO]", "_");
        return new_str;
    }
}
