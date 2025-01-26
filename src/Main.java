import java.util.Date;
import java.util.Scanner;

/**
 * Main class to demonstrate customer operations
 */
public class Main {
    public static void main(String[] args) {
        // Create a new customer and perform various transactions
        Customer customer = new Customer();
        Scanner scannerObj = new Scanner(System.in);
        String selectedAccount = "";
        String selectedAction = "";
        double selectedAmount = 0;

        while (true) {
            while (true) {
                System.out.println("Which account account would you like to interact with (SAVING/CHECKING)");
                selectedAccount = scannerObj.nextLine();

                // Checks for valid input
                if ("SAVING".equals(selectedAccount) || "CHECKING".equals(selectedAccount)) {
                    break;
                } else {
                    System.out.println("Please enter valid input!");
                    continue;
                }
            }

            // Checks for valid input
            while (true) {
                System.out.println("What would you like to do? (withdraw/deposit)");
                selectedAction = scannerObj.nextLine();
                if ("withdraw".equals(selectedAction) || "deposit".equals(selectedAction)) {
                    break;
                } else {
                    System.out.println("Please enter valid input!");
                    continue;
                }
            }

            System.out.println("How much would you like to deposit/withdraw");

            // Checks for valid input and rounds valid input to 100th decimal point if needed
            while (true) {
                try {
                    selectedAmount = Double.parseDouble(scannerObj.nextLine());
                    selectedAmount = Math.round(selectedAmount * 100.0) / 100.0;

                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid input!");
                    continue;
                }
                break;
            }
            // Checks all variable values to see which methods to execute
            if ("deposit".equals(selectedAction))
                if ("SAVING".equals(selectedAccount))
                    customer.deposit(selectedAmount, new Date(), customer.SAVING);
                else {
                    customer.deposit(selectedAmount, new Date(), customer.CHECKING);
                }
            else {
                if ("SAVING".equals(selectedAccount))
                    customer.withdraw(selectedAmount, new Date(), customer.SAVING);
                else {
                    customer.withdraw(selectedAmount, new Date(), customer.SAVING);
                }
            }

            // Display all transactions and account balances
            customer.displayAll();
        }
    }
}
