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

        if (dp[i][target] != null) { // htat why we are using Boolean instead of boolean
            return dp[i][target];
        }

        boolean notTake = targSum(nums, i - 1, target, res, dp);
        boolean take = false;

        if (nums[i] <= target) {
            take = targSum(nums, i - 1, target - nums[i], res, dp);
        }

        return dp[i][target] = take || notTake;
    }

    // // ________//__________//__________//__________//__________

    // Q.2. Find two subsets in which their sum are equal (Partition Equal Subset
    // Sum)

    // step 1. take sum of all elements in the array
    // step 2. find target = sum/2 and store those elements in list (using above
    // problem)

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

    // // ________//__________//__________//__________//__________

    // Q.4. Find two no. of subsets in which they have given k difference(Count
    // Partitions With Given Difference)

    // same as above approach just count |s1-s2| == k

    // // ________//__________//__________//__________//__________
    public static void main(String args[]) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int sum = 10;
        int res[] = { 0 };
        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
        // System.out.println(targetSubSetTab(arr, sum));
        // List<Integer> list = new ArrayList<>();
        // mytarSumMemo(arr, 0, 0, sum, list);

        // Map<String, Boolean> dp = new HashMap<>();
        // mytarSumMemo(arr, 0, 0, sum, list, dp);
        // System.out.println(targSum(arr, arr.length - 1, sum, res, dp));
        // System.out.println(res[0]);
    }
}
