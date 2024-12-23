import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestDeposit {
    @Test
    public void TestDeposit() {
        Deposit myDeposit;
        myDeposit = new Deposit(3, new Date("Sun Sep 01 16:33:43 PDT 2024"), "Savings", 540);
        assertEquals("Deposit of: $3.00 Date: Sun Sep 01 16:33:43 PDT 2024 into account: Savings Current Balance in Saving is: $540.00", ""+myDeposit);
    }
}
