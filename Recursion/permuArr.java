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

    // ____________________________________________________________________
    /*
     * Permutation is all types of arrangements = "abc","bca","cab",....
     * Combination is same as subsequence
     */

    public static void Combi(int[] nums, int i, List<Integer> list) {

        if (i == nums.length) {
            System.out.println(list);
            return;
        }

        list.add(nums[i]);// include
        Combi(nums, i + 1, list);

        list.remove(list.size() - 1);// exclude
        Combi(nums, i + 1, list);
    }

    public static void printPermu01s(int n, String str, ArrayList<String> arr) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printPermu01s(n - 1, str + '1', arr);
        printPermu01s(n - 1, str + '0', arr);

    }

    public static void main(String args[]) {

        int nums[] = { 1, 2, 3 };

        // List<List<Integer>> res = new ArrayList<>();
        // List<Integer> ds = new ArrayList<>();
        // int n = nums.length;
        // boolean[] map = new boolean[n];

        // permutations(nums, ds, map, res);

        // System.out.println(res);

        List<Integer> list = new ArrayList<>();

        Combi(nums, 0, list);
    }
}