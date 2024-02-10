import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class _12_Digits {
    public static int nOfDigi(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();

        int l = nOfDigi(low);
        int h = nOfDigi(high);

        for (int n = l; n <= h; n++) {

            for (int i = 1; i < 11 - n; i++) {

                int p = n - 1;
                int sum = 0;

                for (int j = i; p >= 0; j++, p--) {
                    sum = sum + (j * (int) Math.pow(10, p));
                }

                if (sum > high) {
                    break;
                } else if (sum < low) {
                    continue;
                } else {
                    list.add(sum);
                }

            }
        }

        return list;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter High :");
        int low = sc.nextInt();
        System.out.println("Enter Low :");
        int high = sc.nextInt();
        System.out.println(sequentialDigits(low, high));
        sc.close();

    }
}