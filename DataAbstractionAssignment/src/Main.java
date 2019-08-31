import java.util.Date;

public class Main {
    public static void main(String[] args){

        Date date = new Date();
        Customer customer = new Customer();

        customer.deposit(300, date, "saving");
        customer.displayDeposits();
        customer.withdraw(300, date, "saving");
        customer.displayWithdraws();

        System.out.println();

        customer.deposit(1000, date, "checking");
        customer.displayDeposits();
        customer.withdraw(600, date, "checking");
        customer.displayWithdraws();


    }
}
