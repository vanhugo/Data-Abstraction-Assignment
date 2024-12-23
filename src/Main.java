import java.util.Date;

/**
 * Main class to demonstrate customer operations
 */
public class Main {
    public static void main(String[] args) {
        // Create a new customer and perform various transactions
        Customer customer = new Customer();

        // Perform deposits and withdrawals for savings account
        customer.deposit(500, new Date(), Customer.SAVING);
        customer.withdraw(250.50, new Date(), Customer.SAVING);

        // Perform deposits and withdrawals for checking account
        customer.deposit(750, new Date(), Customer.CHECKING);
        customer.deposit(1000, new Date(), Customer.CHECKING);
        customer.withdraw(75.25, new Date(), Customer.CHECKING);

        // Display all transactions and account balances
        customer.displayAll();
    }
}
