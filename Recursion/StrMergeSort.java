import java.util.Arrays;

public class StrMergeSort {

    public static void merge(String[] arr, int start, int mid, int end) {

        int p1 = start;
        int p2 = mid + 1;
        int size = end - start + 1;
        String[] narr = new String[size];
        int i = 0;

        while (p1 <= mid && p2 <= end) {

            if (arr[p1].compareTo(arr[p2]) < 0) { // if str1 is smaller than str2 in alphabetical order
                narr[i] = arr[p1];
                i++;
                p1++;
            } else {
                narr[i] = arr[p2];
                i++;
                p2++;
            }
        }

        while (p1 <= mid) {
            narr[i] = arr[p1];
            i++;
            p1++;
        }
        while (p2 <= end) {
            narr[i] = arr[p2];
            i++;
            p2++;
        }

        for (int j = 0; j < size; j++) {
            arr[start + j] = narr[j];
        }

    }

    public static void divide(String[] arr, int start, int end) {

        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;

        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void main(String args[]) {

        String[] arr = { "sun", "earth", "mars", "mercury" };

        int n = arr.length;

        divide(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }
}
