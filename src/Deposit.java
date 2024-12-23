import java.util.Date;

/**
 * Deposit class to represent a deposit transaction
 */
public class Deposit {
    // Fields to store the deposit amount, date, account type, and resulting balance
    private double amount;
    private Date date;
    private String account;
    private double balance;

    // Constructor to initialize a deposit with its details
    Deposit(double amount, Date date, String account, double balance) {
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }

    // Overridden toString method to provide a string representation of the deposit
    public String toString() {
        return String.format("Deposit of: $%.2f Date: %s into account: %s Current Balance in Saving is: $%.2f",
                amount, date, account, balance);
    }
}
