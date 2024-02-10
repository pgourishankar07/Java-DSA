public class WaveSort {
    // Function to swap elements in the array
    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 7, 5, 6, 2 };
        int n = arr.length;

        // Wave Sort Algorithm
        for (int i = 1; i < n; i += 2) {
            // Swap with the previous element if it's smaller
            if (arr[i] > arr[i - 1]) {
                swap(arr, i, i - 1);
            }

            // Swap with the next element if it exists and is smaller
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }

        // Display the sorted array in wave form
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
