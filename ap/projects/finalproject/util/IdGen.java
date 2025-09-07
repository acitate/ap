package ap.projects.finalproject.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdGen {
    private static final int MIN = 10000;
    private static final int MAX = 99999;
    private Set<Integer> generatedNumbers = new HashSet<>();
    private Random random = new Random();

    public Integer generateID() {
        if (generatedNumbers.size() >= (MAX - MIN + 1)) {
            System.out.println("All numbers used!");
            return -1;
        }

        int number;
        do {
            number = random.nextInt((MAX - MIN) + 1) + MIN;
        } while (generatedNumbers.contains(number));

        generatedNumbers.add(number);
        return number;
    }
}
