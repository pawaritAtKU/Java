package week7;

import java.util.Scanner;
public class OddEvenNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Odd Numbers:");
        for (int num : arr)
        {
            if (num % 2 != 0)
            {
                System.out.print(num + " ");
            }
        }
        System.out.println("\nEven Numbers:");
        for (int num : arr)
        {
            if (num % 2 == 0)
            {
                System.out.print(num + " ");
            }
        }
        scanner.close();
    }

}