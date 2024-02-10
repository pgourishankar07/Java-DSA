import java.util.ArrayList;
import java.util.List;

class permuArr {

    public static void permutations(int[] nums, List<Integer> ds, boolean[] map, List<List<Integer>> res) {

        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                map[i] = true;
                ds.add(nums[i]);

                permutations(nums, ds, map, res);

                ds.remove(ds.size() - 1);
                map[i] = false;
            }
        }

    }

    public static void main(String args[]) {

        int nums[] = { 1, 2, 3 };

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;
        boolean[] map = new boolean[n];

        permutations(nums, ds, map, res);

        System.out.println(res);

    }
}