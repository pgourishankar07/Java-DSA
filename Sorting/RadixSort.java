import java.util.Arrays;

public class RadixSort {

    // Find the maximum element in the array
    public static int maxOf(int[] arr, int n) {
        int maxi = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxi) {
                maxi = arr[i];
            }
        }
        return maxi;
    }

    // Counting Sort for a specific digit (div)
    public static void countSort(int[] arr, int n, int div) {
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / div) % 10]++;
        }

        // Modify count array to store actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array by placing elements in their correct position
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / div) % 10] - 1] = arr[i];
            count[(arr[i] / div) % 10]--;
        }

        // Copy the sorted output array back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Radix Sort algorithm
    public static void radixSort(int[] arr, int n) {
        int maxNum = maxOf(arr, n);

        // Perform counting sort for each digit place (div)
        for (int div = 1; maxNum / div > 0; div *= 10) {
            countSort(arr, n, div);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 12, 113, 10, 90 };
        int n = 5;

        radixSort(arr, n);

        // Print the sorted array
        System.out.println("The sorted array is : ");
        System.out.println(Arrays.toString(arr));
    }
}
