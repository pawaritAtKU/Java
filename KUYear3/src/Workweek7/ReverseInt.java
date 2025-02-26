package Workweek7;

public class ReverseInt {
    public static void main(String[] args) {
        int number = 1234;
        int reversed = 0;
        System.out.println("Original Number: " + number);
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
            System.out.println("Reversed Number: " + reversed);
        }
    }

}