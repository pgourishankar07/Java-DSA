public class Basics {

    // memoization
    public static int fibo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
        return dp[n];
    }

    // climbing stairs
    public static int climb(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
        return dp[n];

    }

    // tribonaci
    public int tribonacci(int n) {

        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String args[]) {

        int n = 10;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            System.out.println(fibo(i, dp));
        }
        System.out.println();

        // tabulation
        dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for (int i : dp) {
            System.out.println(i);
        }
        System.out.println();

        // _________Normal mode__________ this is SPace Optimization
        int n1 = 0;
        int n2 = 1;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = n1 + n2;
            System.out.println(temp);
            n1 = n2;
            n2 = temp;
        }
        System.out.println();

        // climb______
    }
}
