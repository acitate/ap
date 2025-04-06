package ap.exercises.ex2;
import java.util.*;


public class Main_EX2_PM_2_4 {
    public static void main(String[] args) {

        int k=9; //عدد مربوط به تمرین EX2_PM_1_1 و EX2_PM_1_2
        int c=15; //عدد مربوط به تمرین EX2_PM_1_3

        Random rnd = new Random();

        PacmanEngine pacmanEngine = new PacmanEngine(k,c);
        pacmanEngine.printMatrix();


        while(true) {
            pacmanEngine.printMatrix(); // مربوط به بخش آخر تمرین EX2_PM_1_3
            pacmanEngine.printScore(); // امتیاز تمرین EX2_PM_2_2
            pacmanEngine.printRemainTime(); // زمان تمرین EX2_PM_2_2

            try {
                Thread.sleep(2000);
            } catch (Exception e) {}

            int direction=rnd.nextInt(4);
            pacmanEngine.move(direction);// حرکت نقطه خوار مربوط به تمرین EX2-PM.1.5
//            pacmanEngine.save();
        }
    }
}


class PacmanEngine {
    char[][] array;
    int d, k;
    int score = 0;
    int row = 1, col = 1;
    long start = System.currentTimeMillis();



    public PacmanEngine(int k, int c) {
        this.d = k + 2;
        this.k = k;
        this.array = new char[d][d];


        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if ((i == 0 || j == 0) || (i == k+1 || j == k+1)) {
                    this.array[i][j] = '*';
                }
                else {
                    this.array[i][j] = ' ';
                }
            }
        }


        if (c > (k*k) - 1) {
            System.out.println("Error");
        }

        Integer[] pair;
        ArrayList<Integer[]> pairs = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if (!(i == 1 && j == 1)) {
                    pair = new Integer[]{i, j};
                    pairs.add(pair);
                }
            }
        }
        Collections.shuffle(pairs);


        for (int i = 0; i < c; i++) {
            pair = pairs.get(i);
            this.array[pair[0]][pair[1]] = '.';
        }
        this.array[1][1] = 'X';
    }


    void printMatrix() {
        for (int i = 0; i < this.d; i++) {
            for (int j = 0; j < this.d; j++) {
                System.out.print(this.array[i][j]);
            }
            System.out.print("\n");
        }
    }

    void printScore() {
        System.out.println(this.score);
    }


    void move(int direction) {
        switch (direction) {
            case (0):
                System.out.println("w, up");
                if (this.row - 1 == 0) {
                    System.out.println("hitting the game wall");
                } else {
                    this.array[this.row][this.col] = ' ';
                    this.row--;
                    this.score = (this.array[this.row][this.col] == '.') ? this.score + 1: this.score;
                    this.array[this.row][this.col] = 'X';
                }
                break;
            case (1):
                System.out.println("d, right");
                if (this.col == this.k) {
                    System.out.println("hitting the game wall");
                } else {
                    this.array[this.row][this.col] = ' ';
                    this.col++;
                    this.score = (this.array[this.row][this.col] == '.') ? this.score + 1: this.score;
                    this.array[this.row][this.col] = 'X';
                }
                break;
            case (2):
                System.out.println("s, down");
                if (this.row == this.k) {
                    System.out.println("hitting the game wall");
                } else {
                    this.array[this.row][this.col] = ' ';
                    this.row++;
                    this.score = (this.array[this.row][this.col] == '.') ? this.score + 1: this.score;
                    this.array[this.row][this.col] = 'X';
                }
                break;
            case (3):
                System.out.println("a, left");
                if (this.col - 1 == 0) {
                    System.out.println("hitting the game wall");
                } else {
                    this.array[this.row][this.col] = ' ';
                    this.col--;
                    this.score = (this.array[this.row][this.col] == '.') ? this.score + 1: this.score;
                    this.array[this.row][this.col] = 'X';
                }
                break;
        }
    }


    void printRemainTime() {
        long finish = System.currentTimeMillis();

        System.out.println(finish - start);
    }
}


