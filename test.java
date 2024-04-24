
public class test {
    public static void printSubarrays(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3 };
        // printSubarrays(arr);
        System.out.println(Math.ceil((double) 10 / 3));
    }

}

class Solution {

    ic long sumUp(int n) {
        return (long) n * (n + 1) / 2;
    }

    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;

        System.out.println(n);

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && nums[j] != nums[j + 1]) {
                j++;
            }
            count += sumUp(j - i + 1);
            i = j;
        }

        return count;
    }
}
