package ap.exercises.ex4;

public class Main_EX4_LM_3_15 {
    public static void main(String[] args) {
        Letter letter = new Letter("Mary", "John");

        letter.addLine("I am sorry we must part.");
        letter.addLine("I wish you all the best.");

        System.out.println(letter.getText());
    }
}


class Letter {
    private String from, to;
    private String text;

    public Letter(String from, String to) {
        this.from = from;
        this.to = to;
        this.text = "Dear " + this.to + ":\n\n";
    }

    public void addLine(String Line) {
        this.text += Line + "\n";
    }

    public String getText() {
        this.text += "\nSincerely,\n\n" + this.from;
        return this.text;
    }
}