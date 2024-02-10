
// ________INSERTION SORT________(insert an element from unsorted array to its
// correct position in sorted array)
import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter length: ");
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println("Unsorted list is :");

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println("\nSorted list is :");
    // _______________________________________
    for (int i = 1; i < n; i++) {
      int curr = arr[i];
      int prev = i - 1;

      while (prev >= 0 && arr[prev] > curr) { // traversing in reverse order from i to 0
        arr[prev + 1] = arr[prev]; // moving the larger no.
        prev--;
      }
      arr[prev + 1] = curr; // insertion
    }
    // _______________________________________
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

    scanner.close();
  }
}

// time complexity : n2

// but for inbuit Arrays.sort() : n logn
