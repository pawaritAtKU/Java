package testgptbeformidterm.ClassObjectConstructor;

public class Main  {
    public static void main(String[] args) {
        Book b1 = new Book("put","pawarit",2000.00);
        b1.displayDetails();

        Book b2 = new Book("Aom","anong",30000.00);
        b2.displayDetails();
    }
}
