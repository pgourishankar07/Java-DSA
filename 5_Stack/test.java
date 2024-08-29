import java.util.Scanner;
import java.util.Stack;

public class test {
    public int[] asteroidCollision(int[] nums) {

        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        stk.push(nums[i]);
        i++;

        while (i < n) {
            if ((nums[i] < 0 && stk.peek() > 0) || (stk.peek() < 0 && nums[i] > 0)) {

                boolean neg1 = nums[i] < 0;
                boolean neg2 = stk.peek() < 0;

                while (Math.abs(nums[i]) == Math.abs(stk.peek())) {
                    stk.pop();
                    i++;
                }

                if (Math.abs(nums[i]) < Math.abs(stk.peek())) {
                    stk.pop();
                }

            } else {
                stk.push(nums[i]);
            }
        }
    }
}
