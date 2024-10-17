// ___________Dutch National Flag __________
/*
sorting the array consits of 0,1,2
*/

import java.util.Arrays;

public class DNFsort {
    static void swap(int arr[], int m, int h) {
        int temp = arr[m];
        arr[m] = arr[h];
        arr[h] = temp;
    }

    static void dnfSort(int arr[], int n) {
        int low = 0; // pointing to the first element
        int mid = 0; // starting from the first element
        int h = n - 1; // pointing to the last element

        while (mid <= h) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++; // to progress
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, h);
                h--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 0, 0, 1, 2, 2, 1, 0 };
        int n = 10;
        dnfSort(arr, n);
        System.out.println("The sorted array is : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
 * TIME COMPLEXITY = n
 * becasuse every time either mid++ or high-- so they will be meet at a point
 */