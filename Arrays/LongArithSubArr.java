//Longest Arithmetic Sub Array(cpp playlist :23)
public class LongArithSubArr {
    public static void main(String args[]) {
        int arr[] = { 10, 7, 4, 6, 8, 10, 11 };

        int maxi = Integer.MIN_VALUE;
        int count = 1;
        int d = arr[1] - arr[0]; // -3
        for (int i = 2; i < arr.length; i++) {
            int curr = arr[i] - arr[i - 1];
            if (curr == d) {
                count++;
            } else {
                count = 1;
            }
            maxi = Math.max(maxi, count);
            d = curr;
        }
        System.out.println(maxi + 1);
    }
}
