package Workweek7;

import java.util.Scanner;
public class Bubble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] data = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++)
        {
            data[i] = scanner.nextInt();
        }

        System.out.println("Before sorting:");
        printArray(data);
        bubbleSort(data);
        System.out.println("After sorting:");
        printArray(data);
        scanner.close();
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void printArray(int[] arr) {
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}