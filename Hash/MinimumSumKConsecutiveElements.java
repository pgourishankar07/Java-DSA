
public class MinimumSumKConsecutiveElements {

    public static int minSumOfKConsecutive(int[] nums, int k) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                minSum = Math.min(minSum, sum);
                sum -= nums[i - k + 1];
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 7, 90, 20, 10, 50, 40 };
        int k = 3;

        int minSum = minSumOfKConsecutive(nums, k);
        System.out.println("Minimum sum of " + k + " consecutive elements: " + minSum);
    }
}
