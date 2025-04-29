package ap.exercises.ex4;

public class Main_EX4_LM_3_10 {
    public static void main(String[] args) {
        CashRegister c = new CashRegister();
        c.recordPurchase(102);
        c.recordPurchase(12);
        c.recordPurchase(57);
        c.printRecepit();
    }
}


class CashRegister {
    private double purchase;
    private double payment;
    private String all_purchases;

    public CashRegister() {
        this.purchase = 0;
        this.payment = 0;
        this.all_purchases = "";
    }

    public void recordPurchase(double amount) {
        this.purchase += amount;
        all_purchases = this.all_purchases.concat(String.valueOf(amount) + " ");
    }

    public void recievePayment(double amount) {
        this.payment += amount;
    }

    public double giveChange() {
        double change = payment - purchase;
        payment = 0;
        purchase = 0;
        return change;
    }

    public void printRecepit() {
        System.out.println(all_purchases.concat(String.valueOf(this.purchase)));

    }



}