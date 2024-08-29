import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        divide(arr, low, high);
    }

    static void divide(int[] arr, int low, int high) {
        if (low < high) {

            int mid = low + ((high - low) / 2);
            divide(arr, low, mid);
            divide(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int size = high - low + 1;
        int newArr[] = new int[size];
        int i = 0;
        while (p1 <= mid && p2 <= high) {
            if (arr[p1] <= arr[p2]) {
                newArr[i] = arr[p1];
                i++;
                p1++;
            } else {
                newArr[i] = arr[p2];
                i++;
                p2++;
            }
        }

        while (p1 <= mid) {
            newArr[i] = arr[p1];
            i++;
            p1++;
        }
        while (p2 <= high) {
            newArr[i] = arr[p2];
            i++;
            p2++;
        }

        for (i = 0, p1 = low; i < size; i++, p1++) {
            arr[p1] = newArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 6, 1, 5, 3 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
