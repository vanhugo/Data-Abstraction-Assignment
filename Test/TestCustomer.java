import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * TestCustomer class to test the functionality of the Customer class
 */
public class TestCustomer {
    // Field to store a customer object for testing
    private Customer customer;

    // A small delta value for comparing floating-point values
    private final static double delta = 0.0001;

    // Method to set up a new customer instance before each test
    @Before
    public void setup() {
        customer = new Customer();
    }

    // Test method for deposit functionality
    @Test
    public void testDeposit() {
        // Initial account balances should be zero
        assertEquals(0, customer.getCheckBalance(), delta);
        assertEquals(0, customer.getSavingBalance(), delta);

        // Test deposits to savings account
        customer.deposit(500, new Date(), Customer.SAVING);
        assertEquals(500, customer.getSavingBalance(), delta);

        customer.deposit(460, new Date(), Customer.SAVING);
        assertEquals(960, customer.getSavingBalance(), delta);

        // Test deposits to checking account
        customer.deposit(500, new Date(), Customer.CHECKING);
        assertEquals(500, customer.getCheckBalance(), delta);

        customer.deposit(460, new Date(), Customer.CHECKING);
        assertEquals(960, customer.getCheckBalance(), delta);

        // Test invalid deposits
        customer.deposit(-100, new Date(), Customer.CHECKING);
        assertEquals(960, customer.getCheckBalance(), delta);

        customer.deposit(-100, new Date(), Customer.SAVING);
        assertEquals(960, customer.getSavingBalance(), delta);

        customer.deposit(-100, new Date(), "INVALID_ACCOUNT");
        assertEquals(960, customer.getSavingBalance(), delta);
        assertEquals(960, customer.getCheckBalance(), delta);
    }

    // Test method for withdrawal functionality
    @Test
    public void testWithdraw() {
        // Initial account balances should be zero
        assertEquals(0, customer.getCheckBalance(), delta);
        assertEquals(0, customer.getSavingBalance(), delta);

        // Test withdrawals from an empty savings account
        customer.withdraw(500, new Date(), Customer.SAVING);
        assertEquals(0, customer.getSavingBalance(), delta);

        // Test withdrawals after deposits
        customer.deposit(1000, new Date(), Customer.SAVING);
        customer.withdraw(460, new Date(), Customer.SAVING);
        assertEquals(540, customer.getSavingBalance(), delta);

        // Test invalid withdrawals
        customer.withdraw(-500, new Date(), Customer.SAVING);
        assertEquals(540, customer.getSavingBalance(), delta);

        customer.withdraw(-100, new Date(), "INVALID_ACCOUNT");
        assertEquals(540, customer.getSavingBalance(), delta);

        // Test withdrawals from checking account
        customer.deposit(1000, new Date(), Customer.CHECKING);
        assertEquals(1000, customer.getCheckBalance(), delta);
    }
}
