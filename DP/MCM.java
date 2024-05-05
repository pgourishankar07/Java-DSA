import java.util.Arrays;

public class MCM {

    // MCM(Matrix Chain Multiplication)________________________________________
    public static int mcm(int[] arr, int i, int j) {

        if (i == j)
            return 0;

        int mini = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int ans = arr[i - 1] * arr[k] * arr[j] + mcm(arr, i, k) + mcm(arr, k + 1, j);

            mini = Math.min(mini, ans);

        }

        return mini;
    }

    // Min. Array jumps________________________________________
    public static int minJumps(int nums[]) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int stps = nums[i];
            int ans = Integer.MAX_VALUE;

            for (int j = i + 1; j <= i + stps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }

            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String args[]) {

        // int arr[] = { 10, 20, 30, 40, 50 };
        // int n = arr.length;

        // System.out.println(mcm(arr, 1, n - 1));

        // ________________________________________

        int arr[] = { 2, 3, 1, 1, 4 };
        System.out.println(minJumps(arr));
    }
}
