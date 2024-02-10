//cpp playlist : 23
public class RecordBreakingDays {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 0, 7, 2, 0, 2, 2, 8 };
        int maxi = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxi) { // 1st condition: curr day should be larger than all previous

                if (i + 1 == arr.length) {
                    System.out.println(arr[i]);
                    break;
                }
                if (arr[i] > arr[i + 1]) { // 2nd condition : curr day should be greater than next day
                    System.out.println(arr[i]);
                }

            }
            maxi = Math.max(maxi, arr[i]);
        }
    }
}
