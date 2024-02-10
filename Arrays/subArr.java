
public class subArr {
    public static void main(String args[]) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int max = 0;

        int prefixArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prefixArr[i] = arr[i];
                continue;
            }
            prefixArr[i] = arr[i] + prefixArr[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int start = i;
                int end = j;
                int sum = start == 0 ? prefixArr[end] : prefixArr[end] - prefixArr[start - 1];
                max = sum > max ? sum : max;
            }
        }
        System.out.println("MAximum Sum : " + max);
    }
}
