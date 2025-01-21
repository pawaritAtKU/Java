package week6;

public class ReveresStr {
    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println("Before reveres a String " + str);
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println("After reveres a String " + rev);
    }
}
