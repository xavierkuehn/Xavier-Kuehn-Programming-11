import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class FunctionTests {
    Customer customer;
    Withdraw withdraw;
    Deposit deposit;
    Date date;

    @Before
    public void setup() { customer = new Customer(); }

    @Test
    public void testDepositToString(){
        //check deposit toString method
        double amount = 0.0;
        String account = "saving";
        System.out.println("Deposit of: $" + amount + " Date: " + date + " into account: " + account);
    }

    @Test
    public void testWithdrawToString(){
        //check withdraw toString method
        double amount = 0.0;
        String account = "saving";
        System.out.println("Withdrawal of: $" + amount + " Date: " + date + " into account: " + account);
    }

    @Test
    public void testDeposit(){
        //check customer deposit method
        customer.deposit(600.01, date, "savings");
    }

    @Test
    public void testWithdraw(){
        //check customer deposit method
        customer.withdraw(600, date, "checking");
    }

}
