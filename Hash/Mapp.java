import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapp {
    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 2);
        map.put("Pakistan", 10);
        map.put("China", 1);
        map.put("USA", 3);

        System.out.println(map);

        System.out.println(map.containsKey("USA"));
        System.out.println(map.containsKey("Nepal"));

        System.out.println(map.get("USA"));
        System.out.println(map.get("Nepal"));

        map.put("USA", 1);
        System.out.println(map.get("USA"));

        map.remove("USA");
        System.out.println(map.get("USA"));

        for (Map.Entry<String, Integer> i : map.entrySet()) { // entrySet contains both key and value pairs
            System.out.println(i.getKey() + " " + i.getValue());
        }

        // ___________________________________________________

        Set<String> keys = map.keySet();
        for (String str : keys) {
            System.out.println(str + " " + map.get(str));
        }

        // .getOrDefault method in HashMap it is similar to if key exists increamennt
        // value or create new val
        // alternative method using .contains
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

    }
}
