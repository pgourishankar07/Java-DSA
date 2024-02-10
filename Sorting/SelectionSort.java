
import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter number of elements to input: ");
    int n = scanner.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      System.out.print("Enter data: ");
      arr[i] = scanner.nextInt();
    }

    System.out.print("Unsorted list is: ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println("\nSorted list is: ");
    // _______________________________________
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) { // for descending order > is used
          minIndex = j;
        }
      }

      // Swap the found minimum element with the first element
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
    // _______________________________________
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

    scanner.close();
  }
}
