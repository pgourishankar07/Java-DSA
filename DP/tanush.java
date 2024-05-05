import java.util.*;

public class tanush {
    public static int answer = 0;

    public static int memoization(int[] array, int index, int target, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = memoization(array, index - 1, target, dp);
        int take = 0;
        if (array[index] <= target) {
            take = memoization(array, index - 1, target - array[index], dp);
        }

        return dp[index][target] = take + notTake;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 3 };
        int[][] dp = new int[array.length][3 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int temp = memoization(array, array.length - 1, 3, dp);
        System.out.println(temp);
    }
}
