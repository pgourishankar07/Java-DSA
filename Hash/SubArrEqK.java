import java.util.HashMap;

public class SubArrEqK {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
