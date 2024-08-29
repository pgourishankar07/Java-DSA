import java.util.Arrays;

public class AllBasics {

    public static void bubleSort(int arr[]) {
        int n = arr.length;
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
            if (swaps == 0) { // the array is already in sorted
                break;
            }
        }
    }

    public static void SelectionSort(int arr[]) { // -----find the samllest no. between 'i' and 'n' and swap it with the
                                                  // ith index at each itertation
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) { // for descending order > is used
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void InsertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int curr = i;
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > arr[curr]) { // traversing in reverse order from i to 0
                arr[prev + 1] = arr[prev]; // moving the larger no.
                prev--;
            }
            arr[prev + 1] = arr[curr]; // insertion
        }
    }

    public static int range(int[] arr, int s) {
        int maxNum = arr[0];

        for (int i = 1; i < s; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }

    public static void CountSort(int arr[]) {
        int n = arr.length;

        int countArrSize = range(arr, n);

        int[] cnt = new int[countArrSize + 1];

        for (int i = 0; i < n; i++) { // frequency array
            cnt[arr[i]]++;
        }

        int i = 0;
        for (int j = 0; j < cnt.length; j++) {
            while (cnt[j] > 0) {
                arr[i] = j;
                i++;
                cnt[j]--;
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = { 2, 8, 5, 3, 9, 4, 1 };
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
