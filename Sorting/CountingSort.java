
//  _____________Count sort__________________________
/*
when sorting small integers with limited range with duplicate
*/

public class CountingSort {
    public static int range(int[] arr, int s) {
        int maxNum = arr[0];

        for (int i = 1; i < s; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }

    public static void countSort(int[] org, int n) {
        int countArrSize = range(org, n);

        int[] cnt = new int[countArrSize + 1];

        for (int i = 0; i < n; i++) { // frequency array
            cnt[org[i]]++;
        }

        int i = 0;
        for (int j = 0; j < cnt.length; j++) {
            while (cnt[j] > 0) {
                org[i] = j;
                i++;
                cnt[j]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] org = { 1, 3, 2, 3, 4, 1, 6, 4, 3 };
        int n = org.length;

        countSort(org, n);

        System.out.println("Sorted array:");
        for (int i : org) {
            System.out.print(i + " ");
        }
    }
}

/*
 * TIME COMPLEXITY ::2n but it will be consuming lot of memory
 * only for postitive and less ranged values
 */