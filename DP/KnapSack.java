
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KnapSack {

    /*
     * 3 types
     * Fractional knapsack (greedy)
     * 0-1 knapsack
     * unbounded knapsack (unlimited take)
     */
    public static int knapSack(int[] val, int[] wgt, int w, int n, int[][] dp) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[w][n] != 0) {
            return dp[w][n];
        }

        int profit1 = knapSack(val, wgt, w, n - 1, dp); // exclude
        int profit2 = Integer.MIN_VALUE;

        if (wgt[n] <= w) {
            profit2 = val[n] + knapSack(val, wgt, w - wgt[n], n - 1, dp); // include
        }

        return dp[w][n] = Math.max(profit1, profit2);
    }

    public static int knapSackTab(int[] val, int[] wgt, int w) {
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) { // i -- item no.

            int v = val[i - 1]; // ith item value
            int wt = wgt[i - 1]; // ith item weight

            for (int j = 1; j <= w; j++) { // j -- bag capacity -- inc. the bag capacity at each iteration

                int exProfit = dp[i - 1][j]; // already present element which is in above of the d[i][j]
                int inProfit = Integer.MIN_VALUE;

                if (wt <= j) {
                    inProfit = v + dp[i - 1][j - wt]; // newly calculated value
                }

                dp[i][j] = Math.max(inProfit, exProfit);
            }
        }

        print(dp);

        return dp[n][w];
    }

    public static void print(int[][] dp) {
        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }
    }

    // // ________//__________//__________//__________//__________
    public static boolean targetSubSetTab(int[] arr, int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) { // i -- no. of items
            int val = arr[i - 1];
            for (int j = 1; j <= sum; j++) { // j -- targetSum

                if (val <= j && dp[i - 1][j - val]) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }

    // // ________//__________//__________//__________//__________Follow this for
    // the target
    // sum__________________________________________________________________________________________________________
    static Boolean isSubsetSum(int n, int arr[], int sum) {
        // code here

        boolean[][] dp = new boolean[n][sum + 1];

        // Initialize the first column to true as sum 0 can always be made with an empty
        // subset
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first row (if only the first element is considered)
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean take = false;
                boolean notTake = dp[i - 1][target];

                if (arr[i] <= target) {
                    take = dp[i - 1][target - arr[i]];
                }

                dp[i][target] = take || notTake;
            }
        }

        // The result will be in dp[n-1][sum]
        return dp[n - 1][sum];

    }

    // _____________________________________________________MEMOIZATION
    static boolean targetSum(int[] arr, int n, int target, int[][] dp) {

        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }

        if (n == 0) {
            return target == arr[n];
        }

        if (target - arr[n] == 0) {
            return true;
        }

        if (n < 0) {
            return false;
        }

        boolean notTake = targetSum(arr, n - 1, target, dp);
        boolean take = false;

        if (arr[n] <= target) {
            take = targetSum(arr, n - 1, target - arr[n], dp);
        }

        dp[n][target] = (take || notTake) ? 1 : 0;

        return (take || notTake);
    }

    static Boolean isSubsetSumM(int n, int arr[], int sum) {
        // code here

        int[][] dp = new int[n][sum + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return targetSum(arr, n - 1, sum, dp);

    }

    // _______________________________________________________________________________________________________________________________________________________________
    public static void mytarSumMemo(int[] nums, int i, int val, int sum, List<Integer> list) {

        if (i == nums.length) {
            if (sum == val) {
                System.out.println(list);
            }
            return;
        }

        val += nums[i];
        list.add(nums[i]);
        mytarSumMemo(nums, i + 1, val, sum, list);

        val -= nums[i];
        list.remove(list.size() - 1);
        mytarSumMemo(nums, i + 1, val, sum, list);
    }

    public static void mytarSumMemo(int[] nums, int i, int val, int sum, List<Integer> list, Map<String, Boolean> dp) {

        // Key for memoization
        String key = i + "-" + val;

        if (dp.containsKey(key)) {
            if (dp.get(key)) {
                System.out.println(list);
            }
            return;
        }

        if (i == nums.length) {
            if (sum == val) {
                System.out.println(list);
                dp.put(key, true);
            } else {
                dp.put(key, false);
            }
            return;
        }

        // Include nums[i] in the subset
        val += nums[i];
        list.add(nums[i]);
        mytarSumMemo(nums, i + 1, val, sum, list);

        // Exclude nums[i] from the subset
        val -= nums[i];
        list.remove(list.size() - 1);
        mytarSumMemo(nums, i + 1, val, sum, list);
    }

    public static boolean targSum(int[] nums, int i, int target, int[] res) {
        if (target == 0) {
            res[0]++;
            return true;
        }

        if (i == 0) {
            if (target == nums[i]) {
                res[0]++;
                return true;
            }
            return false;
        }

        boolean notTake = targSum(nums, i - 1, target, res);
        boolean take = false;

        if (nums[i] <= target) {
            take = targSum(nums, i - 1, target - nums[i], res);
        }

        return take || notTake;
    }
    // // ________//__________//__________//__________//__________

    public static int unKnapSackTab(int[] val, int[] wgt, int w) {
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) { // i -- item no.
            int v = val[i - 1]; // ith item value
            int wt = wgt[i - 1]; // ith item weight
            for (int j = 1; j <= w; j++) { // j -- bag capacity

                int exProfit = dp[i - 1][j]; // already present element which is in above of the d[i][j]
                int inProfit = Integer.MIN_VALUE;

                if (wt <= j) {
                    inProfit = v + dp[i][j - wt]; // newly calculated value // the difference between the 1/0 and
                                                  // unbounded is ,in unbounded u will fill that same item again and
                                                  // agaian that why only i instead of [i-1]
                }

                dp[i][j] = Math.max(inProfit, exProfit);
            }
        }

        return dp[n][w];
    }

    public static int unknapSack(int[] val, int[] wgt, int w, int n, int[][] dp) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[w][n] != 0) {

            return dp[w][n];
        }

        int profit1 = unknapSack(val, wgt, w, n - 1, dp); // exclude
        int profit2 = Integer.MIN_VALUE;

        if (wgt[n] <= w) {
            profit2 = val[n] + unknapSack(val, wgt, w - wgt[n], n, dp); // include (here only changes)
        }

        return dp[w][n] = Math.max(profit1, profit2);
    }

    public static void main(String args[]) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wgt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        int[][] dp = new int[w + 1][val.length + 1];

        // System.out.println(knapSack(val, wgt, w, val.length - 1, dp));

        System.out.println(knapSackTab(val, wgt, w));

        // // ________//__________//__________

        // int arr[] = { 4, 2, 7, 1, 3 };
        // int sum = 10;
        // int res[] = { 0 };
        // System.out.println(targetSubSetTab(arr, sum));
        // List<Integer> list = new ArrayList<>();
        // mytarSumMemo(arr, 0, 0, sum, list);

        // Map<String, Boolean> dp = new HashMap<>();
        // mytarSumMemo(arr, 0, 0, sum, list, dp);
        // System.out.println(targSum(arr, arr.length - 1, sum, res));
        // System.out.println(res[0]);

        // // ________//__________//__________

        // System.out.println(unKnapSackTab(val, wgt, w));
        // System.out.println(unknapSack(val, wgt, w, val.length - 1, dp));

    }
}
