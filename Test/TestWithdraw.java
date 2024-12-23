import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestWithdraw {
    @Test
    public void TestWithdraw() {
        Withdraw myWithdraw;
        myWithdraw = new Withdraw(3, new Date("Sun Sep 01 16:33:43 PDT 2024"), "Savings", 540);
        assertEquals("Withdrawal of: $3.00 Date: Sun Sep 01 16:33:43 PDT 2024 from account: Savings Current Balance in Saving is: $540.00", ""+myWithdraw);
    }
}
