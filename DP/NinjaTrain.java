public class NinjaTrain {

    public static void myninja(int[][] nums, int i, int prev, int val, String str, int[] res) {
        if (i == nums.length) {
            System.out.println(val);
            res[0] = Math.max(res[0], val);
            return;
        }

        int temp = prev;
        for (int j = 0; j < 3; j++) {
            if (j != prev) {
                prev = j;
                val += nums[i][j];
                str += Integer.toString(nums[i][j]);
                myninja(nums, i + 1, prev, val, str, res);
                prev = temp;
                val -= nums[i][j];
                str = str.substring(0, str.length() - 2);
            }
        }
    }

    public static int ninja(int[][] nums, int day, int last, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (last != task) {
                    maxi = Math.max(maxi, nums[day][task]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != 0) {
            return dp[day][last];
        }

        int maxi = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                last = task;
                int pts = nums[day][task] + ninja(nums, day - 1, last, dp);
                maxi = Math.max(pts, maxi);
            }
        }

        return dp[day][last] = maxi;
    }

    public static int ninjaTab(int[][] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];

        // copy 1st row in dp
        for (int task = 0; task < 3; task++) {
            dp[0][task] = nums[0][task];
        }

        for (int i = 1; i < n; i++) {
            int maxPts = 0;
            for (int task = 0; task < 3; task++) {
                for (int prev = 0; prev < 3; prev++) {
                    if (prev != task) {
                        int pts = nums[i][task] + dp[i - 1][prev];
                        maxPts = Math.max(maxPts, pts);
                    }
                }
                dp[i][task] = maxPts;
            }
        }

        int res = 0;
        for (int task = 0; task < 3; task++) {
            res = Math.max(dp[n - 1][task], res);
        }

        return res;
    }

    public static void main(String args[]) {
        // int arr[][] = {
        // { 10, 40, 70 },
        // { 20, 50, 80 },
        // { 30, 60, 90 }
        // };
        // // int n = arr.length;
        // int[] res = { 0 };
        // System.out.println("These are the all possible ways :");
        // myninja(arr, 0, -1, 0, "", res);
        // System.out.println("Max. points : " + res[0]);

        // __________//_____________

        int arr[][] = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };
        // int[][] dp = new int[arr.length][3];

        // System.out.println(ninja(arr, arr.length - 1, 2, dp));
        System.out.println(ninjaTab(arr));

    }
}
