import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // last element of the array
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // bringing all the smaller elements of pivot to the front
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, high); // placing the pivot element int he centre
        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high); // divide the array into two : small - pivot - high and return the index
                                                // of
            // pivot element

            // System.out.println(Arrays.toString(arr));

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] arr = { -1, 3, 9, 5, -2, 7, 8, 1 };

        quickSort(arr, 0, arr.length - 1);

        System.out.println("The sorted array is : ");
        System.out.println(Arrays.toString(arr));
    }
}
