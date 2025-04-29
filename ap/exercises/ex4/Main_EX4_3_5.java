package ap.exercises.ex4;

public class Main_EX4_LM_3_5 {
    public static void main(String[] args) {
        LampCircuit circuit = new LampCircuit();
        CircuitTester tester = new CircuitTester();

        System.out.println("Both switch off");
        tester.printStatus(circuit, 1, 1, 0);

        System.out.println("\nToggle first switch only");
        circuit.toggleFirstSwitch();
        tester.printStatus(circuit, 0, 1, 1);

        System.out.println("\nBoth switch on");
        circuit.toggleSecondSwitch();
        tester.printStatus(circuit, 0, 0, 0);

        System.out.println("\nToggle second switch only");
        circuit.toggleFirstSwitch();
        tester.printStatus(circuit, 1, 0, 1);
    }
}


class CircuitTester {

    public void printStatus(LampCircuit circuit, int expectedFirstSwitch, int expectedSecondSwitch, int expectedLamp) {
        int actualFirstSwitch = circuit.getFirstSwitchState();
        int actualSecondSwitch = circuit.getSecondSwitchState();
        int actualLamp = circuit.getLampState();

        System.out.println("Expected first switch state: " + expectedFirstSwitch + "  ;  Actual first switch state: " + actualFirstSwitch);
        System.out.println("Expected second switch state: " + expectedSecondSwitch + "  ;  Actual second switch state: " + actualSecondSwitch);
        System.out.println("Expected Lamp state: " + expectedLamp + "  ;  Actual Lamp state: " + actualLamp);
    }
}