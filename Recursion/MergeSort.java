
class MergeSort {

    public static void merge(int[] arr, int start, int mid, int end) // merge 2 sorted arrays
    {
        int p1 = start; // start pointer at first array [ start , mid ]
        int p2 = mid + 1; // start pointer at second array [ mid+1 , end]
        int size = end - start + 1; // doubt
        int[] narr = new int[size];
        int i = 0;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] < arr[p2]) {
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

        for (i = 0, p1 = start; i < size; i++, p1++) {
            arr[p1] = narr[i]; // doubt
        }

    }

    public static void divide(int[] arr, int start, int end) {
        if (start == end) // single element is present -- when mid reaches left corner and mid+1 reaches
                          // rigth corner
        {
            return;
        }
        int mid = start + (end - start) / 2; // start + (end - start) / 2 is better than start+end / 2 for finding midle
        // divide array into two parts
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        // then merge
        merge(arr, start, mid, end);
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] arr = { 7, 6, 2, 1, 9, 5, 4, 3, 8 };
        divide(arr, 0, arr.length - 1); // sort( array , start , end)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

// if u are not using recursion for merge sort then the condition is 2 array
// should be in sorte position