package ap.exercises.ex4;

public class Main_EX4_LM_3_4 {
    public static void main(String[] args) {
        LampCircuit c = new LampCircuit();
    }
}


class LampCircuit {
    private int firstSwitch;
    private int secondSwitch;

    public LampCircuit() {
        firstSwitch = 1;
        secondSwitch = 1;
    }

    public int getFirstSwitchState() {
        return firstSwitch;
    }

    public int getSecondSwitchState() {
        return secondSwitch;
    }

    public int getLampState() {
        return (firstSwitch != secondSwitch)? 1 : 0;
    }

    public void toggleFirstSwitch() {
        firstSwitch = (firstSwitch == 1)? 0 : 1;
    }

    public void toggleSecondSwitch() {
        secondSwitch = (secondSwitch == 1)? 0 : 1;
    }
}