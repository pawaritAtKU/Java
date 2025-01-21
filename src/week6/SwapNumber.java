package week6;

public class SwapNumber {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        System.out.println("Before Swapping: " + a + " " + b + " " + c + " " + d);

        int temp = a;
        a = d;
        d = temp;
        temp = b;
        b = c;
        c = temp;
        System.out.println("After Swapping: " + a + " " + b + " " + c + " " + d);
    }
}

