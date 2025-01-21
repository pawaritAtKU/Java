package testgptbeformidterm.GetterSetter;

public class Main {
    public static void main(String[] args) {
        // สร้าง object ของ BankAccount
        BankAccount bk = new BankAccount("2000", "pawarit", 2000000.0);

        // ใช้ Getter เพื่อแสดงข้อมูล
        System.out.println("Account Number: " + bk.getAccountNumber());
        System.out.println("Account Holder: " + bk.getAccountHolder());
        System.out.println("Balance: " + bk.getBalance());

        // ใช้ Setter เพื่ออัปเดตข้อมูล
        bk.setAccountHolder("Anong");
        bk.setBalance(300000.0);

        // แสดงข้อมูลที่อัปเดต
        System.out.println("\nUpdated Account Info:");
        System.out.println("Account Number: " + bk.getAccountNumber());
        System.out.println("Account Holder: " + bk.getAccountHolder());
        System.out.println("Balance: " + bk.getBalance());
    }
}
