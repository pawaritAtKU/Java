package permidtearm.GetterSetter;

public class BankAccount extends Main {
    String accountNumber;
    String accountHolder;
    double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        setBalance(balance);
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public void setBalance(double balance){
        if(balance >= 0)
            this.balance = balance;
        else{
            System.out.println("Balance cannot be negative!");
        }
    }
}
