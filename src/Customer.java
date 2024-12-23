import java.util.ArrayList;
import java.util.Date;

/**
 * Customer class to manage banking transactions and account balances
 */
public class Customer {
    // Fields to store customer account details
    private int accountNumber;
    private ArrayList<Deposit> deposits; // List of deposit transactions
    private ArrayList<Withdraw> withdraws; // List of withdrawal transactions
    private double checkBalance; // Balance for checking account
    private double savingBalance; // Balance for savings account
    private double savingRate; // Savings interest rate
    private String name; // Customer name

    // Constants to define account types
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";

    // Constant to define overdraft limit
    private final int OVERDRAFT = -100;

    // Default constructor to initialize a new customer with default values
    Customer() {
        this.name = "";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
        this.savingRate = 0;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    // Constructor to initialize a new customer with specific values
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.savingRate = 0;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    // Method to perform a deposit transaction
    public double deposit(double amt, Date date, String account) {
        if (amt < 0) {
            System.out.println("Deposit amount must not be negative");
            return 0;
        }
        if (account != SAVING && account != CHECKING) {
            System.out.println("Account must be Checking or Saving");
            return 0;
        }
        double balance = (account == SAVING) ? savingBalance : checkBalance;
        balance += amt;
        Deposit deposit = new Deposit(amt, date, account, balance);
        deposits.add(deposit);
        if (account == SAVING) {
            savingBalance = balance;
        } else {
            checkBalance = balance;
        }
        return 0;
    }

    // Method to perform a withdrawal transaction
    public double withdraw(double amt, Date date, String account) {
        if (amt < 0) {
            System.out.println("Withdrawal amount must not be negative");
            return 0;
        }
        if (account != SAVING && account != CHECKING) {
            System.out.println("Account must be Checking or Saving");
            return 0;
        }
        if (checkOverdraft(amt, account)) {
            return 0;
        }
        double balance = (account == SAVING) ? savingBalance : checkBalance;
        balance -= amt;
        Withdraw withdraw = new Withdraw(amt, date, account, balance);
        withdraws.add(withdraw);
        if (account == SAVING) {
            savingBalance = balance;
        } else {
            checkBalance = balance;
        }
        return 0;
    }

    // Method to check if a withdrawal exceeds overdraft limit
    private boolean checkOverdraft(double amt, String account) {
        double balance = (account == SAVING) ? savingBalance : checkBalance;
        balance -= amt;
        if (balance < 0) {
            System.out.println("Withdrawal amount must be less than balance");
            return true;
        }
        return false;
    }

    // Method to display all deposit transactions
    public void displayDeposits() {
        for (Deposit d : deposits) {
            System.out.println(d);
        }
    }

    // Method to display all withdrawal transactions
    public void displayWithdraws() {
        for (Withdraw w : withdraws) {
            System.out.println(w);
        }
    }

    // Method to display all transactions and account balances
    public void displayAll() {
        displayDeposits();
        displayWithdraws();
        System.out.println(String.format("Savings Balance: $%.2f \nChecking Balance: $%.2f", savingBalance, checkBalance));
    }

    // Getter for checking account balance
    public double getCheckBalance() {
        return checkBalance;
    }

    // Getter for savings account balance
    public double getSavingBalance() {
        return savingBalance;
    }
}
