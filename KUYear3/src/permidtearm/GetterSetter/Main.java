package permidtearm.GetterSetter;

public class Main {
    public static void main(String[] args) {
        BankAccount bk = new BankAccount("2000", "pawarit", 2000000.0);
        System.out.println("Account Number: " + bk.getAccountNumber());
        System.out.println("Account Holder: " + bk.getAccountHolder());
        System.out.println("Balance: " + bk.getBalance());
        bk.setAccountHolder("Anong");
        bk.setBalance(300000.0);
        System.out.println("\nUpdated Account Info:");
        System.out.println("Account Number: " + bk.getAccountNumber());
        System.out.println("Account Holder: " + bk.getAccountHolder());
        System.out.println("Balance: " + bk.getBalance());
    }
}