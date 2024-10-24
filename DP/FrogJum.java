import java.util.List;

public class FrogJum {
    public static int frogJump(int[] nums, int i, int[] dp) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int one = Math.abs(nums[i] - nums[i - 1]) + frogJump(nums, i - 1, dp); // include
        int two = Integer.MAX_VALUE; // exclude

        if (i > 1) {
            two = Math.abs(nums[i] - nums[i - 2]) + frogJump(nums, i - 2, dp);
        }

        return dp[i] = Math.min(one, two);

    }

    public static int frogJumpTab(int[] nums, int n) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int one = Math.abs(nums[i] - nums[i - 1]) + dp[i - 1];
            int two = Integer.MAX_VALUE;

            if (i > 1) {
                two = Math.abs(nums[i] - nums[i - 2]) + dp[i - 2];
            }

            dp[i] = Math.min(one, two);
        }

        return dp[n - 1];
    }

    public static void frogJumpStps(int[] nums, int i, List<Integer> list) {
        if (i == 0) {
            list.add(nums[i]);
            System.out.println(list);
            return;
        }

        list.add(nums[i]);

        frogJumpStps(nums, i - 1, list);
        list.remove(list.size() - 1);

        if (i > 1) {
            frogJumpStps(nums, i - 2, list);
            list.remove(list.size() - 1);
        }

    }

    public static void myfrogJumpStps(int[] nums, int i, int val, int[] res) {
        if (i == 0) {
            res[0] = Math.min(val, res[0]);
            return;
        }

        val += Math.abs(nums[i] - nums[i - 1]);

        myfrogJumpStps(nums, i - 1, val, res);
        val -= Math.abs(nums[i] - nums[i - 1]);

        if (i > 1) {
            val += Math.abs(nums[i] - nums[i - 2]);
            myfrogJumpStps(nums, i - 2, val, res);
        }

    }

    public static int frogJumpK(int[] nums, int i, int k) {
        if (i == 0) {
            return 0;
        }

        int minStps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            int jump = Integer.MAX_VALUE;
            if (i >= j) {
                jump = Math.abs(nums[i] - nums[i - j]) + frogJumpK(nums, i - j, k);
            }
            minStps = Math.min(jump, minStps);
        }

        return minStps;
    }

    public static int frogJumpKTab(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                int jump = Integer.MAX_VALUE;
                if (i >= j) {
                    jump = Math.abs(nums[i] - nums[i - j]) + dp[i - j];
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }

        return dp[n - 1];
    }

    public static void main(String args[]) {
        // // ________//__________//__________

        // int[] arr = { 10, 20, 30, 10 };
        // int dp[] = new int[arr.length];
        // Arrays.fill(dp, -1);
        // System.out.println(frogJump(arr, arr.length - 1, dp));
        // System.out.println(frogJumpTab(arr, arr.length));

        // // ________//__________//__________

        // int[] arr = { 4, 8, 3, 10, 4, 4 };
        // List<Integer> list = new ArrayList<>();
        // frogJumpStps(arr, arr.length - 1, list);

        // // ________//__________//__________

        // int[] arr = { 4, 8, 3, 10, 4, 4 };
        // int[] res = { Integer.MAX_VALUE };
        // myfrogJumpStps(arr, arr.length - 1, 0, res);
        // System.out.println(res[0]);

        // // ________//__________//__________

        int[] arr = { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };
        int k = 4;
        // System.out.println(frogJumpK(arr, arr.length - 1, k));
        System.out.println(frogJumpKTab(arr, k));
    }

}
