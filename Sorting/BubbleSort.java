import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Unsorted list is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nSorted list is:");
        // _______________________________________
        for (int i = 1; i < n; i++) {
            int swaps = 0;
            for (int j = 0; j < n - i; j++) { // at each iteration last part will be sorted
                if (arr[j] > arr[j + 1]) { // if curr element is greater then swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
            if (swaps == 0) {
                break;
            }
        }
        // _______________________________________
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}

// Time complexity is : n2