import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_3Sum {
    private static boolean present(List<List<Integer>> nestedList, int element1, int element2, int element3,
            String[] flag) {
        for (List<Integer> innerList : nestedList) {
            if (innerList.containsAll(Arrays.asList(element1, element2, element3))) {
                if (element1 == element2 && element2 == element3 && flag[0] == null) {
                    flag[0] = "i";
                    return false;
                }
                return true; // Element found
            }
        }
        if (element1 == element2 && element2 == element3 && flag[0] == null) {
            flag[0] = "i";
        }
        return false; // Element not found
    }

    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        String flag[] = { null };

        List<List<Integer>> nestedList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(null); // Sort the triplet

                        if (!present(nestedList, triplet.get(0), triplet.get(1), triplet.get(2), flag)) {
                            nestedList.add(triplet);
                        }
                    }
                }
            }
        }

        return nestedList;
    }
}
