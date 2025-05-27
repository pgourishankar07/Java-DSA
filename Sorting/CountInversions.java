/*
Count Inversion is to count the inversions formed in an array that is
if a[i]>a[j] and i<j
*/
public class CountInversions {
    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 5, 2, 8, 7, 1 };
        int n = arr.length;
        int inversions = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inversions++;
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }

        System.out.println("The number of inversions formed: " + inversions);
    }
}
