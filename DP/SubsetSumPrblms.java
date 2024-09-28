import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubsetSumPrblms {

    public static boolean targetSubSetTab(int[] arr, int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) { // i -- no. of items
            int val = arr[i - 1];
            for (int j = 1; j <= sum; j++) { // j -- targetSum

                boolean notTake = dp[i - 1][j];
                boolean take = false;

                if (val <= j) {
                    take = dp[i - 1][j - val];
                }

                dp[i][j] = take || notTake;
            }
        }

        return dp[n][sum];
    }

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

    public static boolean targSum(int[] nums, int i, int target, int[] res, Boolean[][] dp) {
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

        if (dp[i][target] != null) { // that why we are using Boolean instead of boolean
            return dp[i][target];
        }

        boolean notTake = targSum(nums, i - 1, target, res, dp);
        boolean take = false;

        if (nums[i] <= target) {
            take = targSum(nums, i - 1, target - nums[i], res, dp);
        }

        return dp[i][target] = take || notTake;
    }

    public static int countTargSum(int[] nums, int i, int target, int[][] dp) {
        if (i < 0) {
            return target == 0 ? 1 : 0;
        }

        if (target == 0) {
            return 1;
        }

        if (dp[i][target] != 0) {
            return dp[i][target];
        }

        int notTake = countTargSum(nums, i - 1, target, dp);
        int take = 0;

        if (nums[i] <= target) {
            take = countTargSum(nums, i - 1, target - nums[i], dp);
        }

        return dp[i][target] = take + notTake;
    }

    // // ________//__________//__________//__________//__________
    // ALL POSSIBLE SUBSET SUM
    public static void helper(int[] arr, int n, List<Integer> list, int sum) {
        if (n < 0) {
            list.add(sum);
            return;
        }

        helper(arr, n - 1, list, sum + arr[n]);
        helper(arr, n - 1, list, sum);

    }
    // // ________//__________//__________//__________//__________

    // Q.2. Find two subsets in which their sum are equal (Partition Equal Subset
    // Sum)

    // step 1. take sum of all elements in the array
    // step 2. find target = sum/2 and store those elements in list (using above
    // problem)

    public static void eqSubSum(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            System.out.println("The Array cannot be partitioned into two equal subsets");
            return;
        }

        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        if (countTargSum(nums, nums.length - 1, target, dp) > 0) {
            System.out.println("The Array can be partitioned into two equal subsets");
        }

    }

    // // ________//__________//__________//__________//__________

    // Q.3. Find two subsets in which they have min. abs. diff. of their sum
    // (Partition A Set Into Two Subsets With Minimum Absolute Sum Difference)

    // constraints all +ve no.s

    // we use tabulation here becoz we can say by looking at a cell whether we can
    // obtain the target using that i no.s in []

    // 0r another approach

    // we need |s1-s2| = Mini.
    // we know s1+s2 = sum
    // so , s2 = sum-s1
    // if we get all possible values of s1 then we can get s2 from above formula so
    // we can get min out of it

    public static void minAbsSumDiff(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            System.out.println("The Array cannot be partitioned into two equal subsets");
            return;
        }

        int[][] dp = new int[nums.length][sum];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        int[] res = { Integer.MAX_VALUE };
        minAbsSumDiffSets(nums, nums.length - 1, 0, sum, res, dp);
        System.out.println(res[0]);
    }

    public static int minAbsSumDiffSets(int[] nums, int i, int val, int sum, int[] res, int[][] dp) {

        if (i < 0) {
            res[0] = Math.min(Math.abs((sum - val) - val), res[0]);
            return val;
        }

        if (dp[i][val] != -1) {
            return dp[i][val];
        }

        int take = minAbsSumDiffSets(nums, i - 1, val + nums[i], sum, res, dp);
        int notTake = minAbsSumDiffSets(nums, i - 1, val, sum, res, dp);

        return dp[i][val] = Math.min(take, notTake);
    }

    // // ________//__________//__________//__________//__________

    // Q.4. Find two no. of subsets in which they have given k difference(Count
    // Partitions With Given Difference)

    // same as above approach just count |s1-s2| == k and use s1 > s2 so that u can
    // filter and count only pairs

    public static void countKDiffSub(int[] nums, int k) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            System.out.println("The Array cannot be partitioned into two equal subsets");
            return;
        }

        int[][] dp = new int[nums.length][sum];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        int[] res = { 0 };
        countKDiffSubSets(nums, nums.length - 1, k, 0, sum, res, dp);
        System.out.println(res[0]);
    }

    public static int countKDiffSubSets(int[] nums, int i, int k, int val, int sum, int[] res, int[][] dp) {

        if (i < 0) {
            if (Math.abs((sum - val) - val) == k && (sum - val) > val) { // so that you can count only no. of pairs
                res[0]++;
            }
            return val;
        }

        if (dp[i][val] != -1) {
            return dp[i][val];
        }

        int take = countKDiffSubSets(nums, i - 1, k, val + nums[i], sum, res, dp);
        int notTake = countKDiffSubSets(nums, i - 1, k, val, sum, res, dp);

        return dp[i][val] = Math.min(take, notTake);
    }

    // // ________//__________//__________//__________//__________
    // L : 494
    public static int memo(int i, int target, int[] arr, int[][] dp) {

        if (i == 0) {
            if (target == 0 && arr[0] == 0)
                return 2; // one by not including any element and another by including the 0th element
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[i][target] != -1)
            return dp[i][target];

        int notTaken = memo(i - 1, target, arr, dp);
        int taken = 0;

        if (arr[i] <= target)
            taken = memo(i - 1, target - arr[i], arr, dp);

        return dp[i][target] = notTaken + taken;
    }

    public static int targetSum(int[] arr, int target) {

        int n = arr.length;

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int s2 = (sum - target);

        if (s2 < 0) // Total sum cant be -ve
            return 0;
        if (s2 % 2 != 0) // sum cant be odd no. then it cant be partitioned
            return 0;

        target = s2 / 2;

        int dp[][] = new int[n][target + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);

        return memo(n - 1, target, arr, dp);
    }

    // Minimum Coins (unbounded knapsack) //
    // ________//__________//__________//__________//__________
    public static int minCoins(int[] nums, int i, int amt, int[][] dp) {
        if (amt == 0 || i == 0) {
            if (amt % nums[0] == 0)
                return amt / nums[0];
            else
                return 10000000;
        }

        if (dp[i][amt] != 0) {
            return dp[i][amt];
        }

        int notTake = minCoins(nums, i - 1, amt, dp);
        int take = 10000000;

        if (nums[i] <= amt) {
            take = 1 + minCoins(nums, i, amt - nums[i], dp);
        }

        return dp[i][amt] = Math.min(take, notTake);
    }

    // // ________//__________//__________//__________//__________
    // no. of ways using coins we can form the target
    public static int coinChange(int[] nums, int i, int target, int[][] dp) {
        if (target == 0 || i == 0) {
            if (target % nums[0] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        int notTake = coinChange(nums, i - 1, target, dp);
        int take = 0;

        if (nums[i] <= target) {
            take = coinChange(nums, i, target - nums[i], dp);
        }

        return dp[i][target] = take + notTake;
    }

    // // ________//__________//__________//__________//__________
    // We are given a rod of size ‘N’. It can be cut into pieces. Each length of a
    // piece has a particular price given by the price array. Our task is to find
    // the maximum revenue that can be generated by selling the rod after cutting(
    // if required) into pieces.
    public static int rodCut(int[] prices, int i, int len, int[][] dp) {
        if (i == 0) {
            return len * prices[i];
        }

        if (i < 0) {
            return 0;
        }

        if (dp[i][len] != 0) {
            return dp[i][len];
        }

        int notTake = rodCut(prices, i - 1, len, dp);
        int take = 0;
        int rodLen = i + 1;

        if (rodLen <= len) {
            take = prices[i] + rodCut(prices, i, len - rodLen, dp);
        }

        return dp[i][len] = Math.max(take, notTake);
    }

    // LAtest
    // RodCutting___________________________________________________________________________________________________________________________________________________
    public int helper(int[] price, int n, int length, int[][] dp) {
        if (n == 0 || length == 0) {
            return 0;
        }

        if (dp[n][length] != -1) {
            return dp[n][length];
        }

        int notTake = helper(price, n - 1, length, dp);
        int take = 0;
        if (n <= length) {
            take = price[n - 1] + helper(price, n, length - n, dp);
        }

        return dp[n][length] = Math.max(take, notTake);
    }

    public static void main(String args[]) {

        // int arr[] = { 4, 2, 7, 1, 3 };
        // int target = 10;

        // int res[] = { 0 };
        // Boolean[][] dp = new Boolean[arr.length + 1][target + 1];

        // System.out.println(targetSubSetTab(arr, target));

        // List<Integer> list = new ArrayListy<>();
        // mytarSumMemo(arr, 0, 0, target, list);

        // Map<String, Boolean> dp = new HashMap<>();
        // mytarSumMemo(arr, 0, 0, target, list, dp);

        // System.out.println(targSum(arr, arr.length - 1, target, res, dp));
        // System.out.println(res[0]);

        // int[][] dp = new int[arr.length][target + 1];
        // System.out.println(countTargSum(arr, arr.length - 1, target, dp));

        // // ________//__________//__________//__________//__________

        // int arr[] = { 2, 3, 3, 3, 4, 5 };
        // eqSubSum(arr);

        // // ________//__________//__________//__________//__________

        // int arr[] = { 8, 6, 5 };
        // minAbsSumDiff(arr);

        // // ________//__________//__________//__________//__________

        // int arr[] = { 5, 2, 6, 4 };
        // countKDiffSub(arr, 3);

        // // ________//__________//__________//__________//__________

        // int[] arr = { 1, 2, 3 };
        // int target = 7;
        // int[][] dp = new int[arr.length + 1][target + 1];

        // System.out.println(minCoins(arr, arr.length - 1, target, dp));

        // // ________//__________//__________//__________//__________
        // int[] arr = { 1, 2, 3 };
        // int target = 4;

        // int n = arr.length;
        // int dp[][] = new int[n + 1][target + 1];

        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }
        // System.out.println(coinChange(arr, n - 1, target, dp));
        // // ________//__________//__________//__________//__________

        int[] arr = { 2, 5, 7, 8, 10 };
        int len = 5;

        int[][] dp = new int[arr.length + 1][len + 1];

        System.out.println(rodCut(arr, arr.length - 1, len, dp));

    }
}
