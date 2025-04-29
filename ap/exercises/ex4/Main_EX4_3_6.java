//package ap.exercises.ex4;

public class Main_EX4_LM_3_6 {
    public static void main(String[] args) {
    }
}


class LampCircuit {
    private int firstSwitch;
    private int secondSwitch;

    public LampCircuit() {
        firstSwitch = 1;
        secondSwitch = 1;
    }

    public int getSwitchState(int switchNum) {
        switch (switchNum) {
            case 1:
                return firstSwitch;

            case 2:
                return secondSwitch;
        }
        return -1;
    }

    public int getLampState() {
        return (firstSwitch != secondSwitch)? 1 : 0;
    }

    public void toggleSwitch(int switchNum) {
        switch (switchNum) {
            case 1:
                firstSwitch = (firstSwitch == 1)? 0 : 1;
                break;

            case 2:
                secondSwitch = (secondSwitch == 1)? 0 : 1;
                break;
        }
    }
}