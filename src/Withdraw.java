import java.util.Date;

/**
 * Withdraw class to represent a withdrawal transaction
 */
public class Withdraw {
    // Fields to store the withdrawal amount, date, account type, and resulting balance
    private double amount;
    private Date date;
    private String account;
    private double balance;

    // Constructor to initialize a withdrawal with its details
    Withdraw(double amount, Date date, String account, double balance) {
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }

    // Overridden toString method to provide a string representation of the withdrawal
    public String toString() {
        return String.format("Withdrawal of: $%.2f Date: %s from account: %s Current Balance in Saving is: $%.2f",
                amount, date, account, balance);
    }
}
