public class LIS {
    public static int lis(int nums[], int i, int prev, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != 0) {
            return dp[i][prev + 1];
        }

        int notTake = lis(nums, i + 1, prev, dp);
        int take = 0;

        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + lis(nums, i + 1, i, dp);
        }

        dp[i][prev + 1] = Math.max(notTake, take);

        return dp[i][prev + 1];
    }

    public static void main(String args[]) {
        int[] nums = { 18, 29, 10, 23, 4, 7, 2, 101 };
        int[][] dp = new int[nums.length][nums.length];
        System.out.println(lis(nums, 0, -1, dp));
    }
}
