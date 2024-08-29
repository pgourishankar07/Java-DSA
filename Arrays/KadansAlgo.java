public class KadansAlgo {
    public static int maxSubArray(int[] nums) {

        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int front = 0; // for printing SubArr
        int back = 0; // for printing SubArr

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                back = i;
            }

            if (sum < 0) {
                sum = 0;
                front = i + 1;
            }

        }

        for (int i = front; i <= back; i++) {
            System.out.print(nums[i] + " ");
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));
    }
}
