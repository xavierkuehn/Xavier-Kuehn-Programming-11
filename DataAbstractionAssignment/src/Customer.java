import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "";
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }

    //Requires: double, date and account
    //Modifies: this
    //Effects: deposits 'amt' into account balance
    public double deposit(double amt, Date date, String account){
        //your code here
        deposits = new ArrayList<>();
        double newBalance = 0.0;

        if(account.equalsIgnoreCase(CHECKING)){
            checkBalance += amt;
            newBalance = checkBalance;
        } else if(account.equalsIgnoreCase(SAVING)){
            savingBalance += amt;
            newBalance = savingBalance;
        }

        deposits.add(new Deposit(amt, date, account));
        return newBalance;
    }

    //Requires: double, date and account name
    //Modifies: this
    //Effects: checks overdraft for account, if false withdraws 'amt' from account balance
    public double withdraw(double amt, Date date, String account){
        //your code here
        withdraws = new ArrayList<>();
        double newBalance = 0.0;

        if(checkOverdraft(amt, account)){
            System.out.println("Cannot withdraw from account. Withdrawal amount exceeds account balance.");
            return OVERDRAFT;
        } else if(account.equalsIgnoreCase(CHECKING)){
            checkBalance -= amt;
            newBalance = checkBalance;
        } else {
            savingBalance -= amt;
            newBalance = savingBalance;
        }

        withdraws.add(new Withdraw(amt, date, account));
        return newBalance;
    }

    //Requires: double and account name
    //Modifies: this
    //Effects: returns if account overdraft is true, otherwise return false
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if(account.equalsIgnoreCase(SAVING)){
            if((savingBalance - amt) < 0){
                return true;
            }
        } else if (account.equalsIgnoreCase(CHECKING)){
            if((checkBalance - amt) < 0){
                return true;
            }
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
