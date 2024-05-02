
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack {

    /*
     * 3 types
     * Fractional knapsack
     * 0-1 knapsack
     * unbounded knapsack
     */
    public static int knapSack(int[] val, int[] wgt, int w, int n, int[][] dp) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[w][n] != 0) {
            return dp[w][n];
        }

        if (wgt[n] <= w) {
            int profit1 = val[n] + knapSack(val, wgt, w - wgt[n], n - 1, dp); // include
            int profit2 = knapSack(val, wgt, w, n - 1, dp); // exclude

            int maxProf = Math.max(profit1, profit2);
            System.out.println(w + " " + n);
            dp[w][n] = maxProf;

            return maxProf;
        } else {
            return knapSack(val, wgt, w, n - 1, dp);
        }
    }

    public static int knapSackTab(int[] val, int[] wgt, int w) {
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) { // i -- item no.

            int v = val[i - 1]; // ith item value
            int wt = wgt[i - 1]; // ith item weight

            for (int j = 1; j <= w; j++) { // j -- bag capacity -- inc. the bag capacity at each iteration

                if (wt <= j) {
                    int inProfit = v + dp[i - 1][j - wt]; // newly calculated value
                    int exProfit = dp[i - 1][j]; // already present element which is in above of the d[i][j]

                    dp[i][j] = Math.max(inProfit, exProfit);
                } else {
                    int exProfit = dp[i - 1][j]; // copy upper element
                    dp[i][j] = exProfit;
                }
            }
        }

        return dp[n][w];
    }

    public static boolean targetSubSet(int[] arr, int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) { // i -- no. of items
            for (int j = 1; j <= sum; j++) { // j -- targetSum

                int v = arr[i - 1];

                if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }

    public static int unKnapSackTab(int[] val, int[] wgt, int w) {
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) { // i -- item no.
            for (int j = 1; j <= w; j++) { // j -- bag capacity

                int v = val[i - 1]; // ith item value
                int wt = wgt[i - 1]; // ith item weight

                if (wt <= j) {
                    // Include the current item and consider including it again (unbounded)
                    int inProfit = v + dp[i][j - wt]; // Newly calculated value with inclusion
                    int exProfit = dp[i - 1][j]; // Profit without including the current item

                    dp[i][j] = Math.max(inProfit, exProfit);
                } else {
                    // The current item cannot be included as it exceeds the capacity
                    // So, profit remains the same as excluding the current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }

    public static void main(String args[]) {
        // int val[] = { 15, 14, 10, 45, 30 };
        // int wgt[] = { 2, 5, 1, 3, 4 };
        // int w = 7;
        // int[][] dp = new int[w + 1][val.length];

        // System.out.println(knapSack(val, wgt, w, val.length - 1, dp));

        // System.out.println(knapSackTab(val, wgt, w));

        // // ________//__________//__________

        // int arr[] = { 4, 2, 7, 1, 3 };
        // int sum = 10;
        // System.out.println(targetSubSet(arr, sum));

        // // ________//__________//__________

        // System.out.println(unKnapSackTab(val, wgt, w));

    }
}
