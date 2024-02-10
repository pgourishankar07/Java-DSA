import java.util.ArrayList;
import java.util.List;

public class countInversion {

    public static List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            res.add(count);
        }

        res.add(0);

        return res;

    }

    public static void main(String args[]) {

    }
}