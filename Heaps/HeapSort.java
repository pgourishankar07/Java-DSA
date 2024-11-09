import java.util.Arrays;

public class HeapSort {

    private static void heapify(int[] arr, int i, int size) {
        int node = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[node] < arr[left]) { // change of sign
            node = left;
        }
        if (right < size && arr[node] < arr[right]) { // change of sign
            node = right;
        }

        if (node != i) { // if thier is a change then swap
            int temp = arr[i];
            arr[i] = arr[node];
            arr[node] = temp;

            // call for next further check
            heapify(arr, node, size);

        }
    }

    public static void heapSort(int arr[]) {

        // build maxHeap for ascending order
        int n = arr.length;

        // if we just call heapify for non leaf nodes(1st half in reverse order) then we
        // will get the heap structure
        // The idea is that by heapifying non-leaf nodes (starting from the last
        // non-leaf node down to the root), you gradually build the heap structure from
        // the bottom up. This approach works well for both max-heaps and min-heaps.

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // swap the 1st element to last - bcoz every time the top element will be sorted
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 3, 5 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/*
 * ascending order - construct max heap
 */
