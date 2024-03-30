import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

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

        // _________________________//__________________________

        Set<String> keys = map.keySet();
        for (String str : keys) {
            System.out.println(str + " " + map.get(str));
        }

        // .getOrDefault method in HashMap it is similar to if key exists increamennt
        // value or create new val
        // alternative method using .contains
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // ______________// ______________// ______________// ______________//

        // LinkedHashMap is used when u want data in insertion order for traverse
        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>(); // internal implementation is doubly LL

        lmap.put("Tano", 80);
        lmap.put("Gouri", 100);
        lmap.put("Gandu", 50);
        lmap.put("Mano", 60);

        System.out.println(lmap);

        // TreeMap is used when u want to sort the key/values uisng any total or natural
        // ordering
        // internal implementation is red balck tree(Self Balancing Tree)
        // Time complexity for : insert,remove,get---o(logn)
        TreeMap<Integer, String> tmap = new TreeMap<>(Collections.reverseOrder());
        tmap.put(80, "Tano");
        tmap.put(60, "Gandu");
        tmap.put(100, "Gouri");
        tmap.put(90, "Mano");
        tmap.put(70, "Lando");

        System.out.println(tmap);

        // ______________// ______________// ______________// ______________//

        int[] array = { 5, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };

        // Create a HashMap to store frequencies
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Define a custom Comparator to sort by frequency
        Comparator<Integer> frequencyComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) { // a and b are the keys
                int freqComparison = frequencyMap.get(b).compareTo(frequencyMap.get(a));
                return freqComparison != 0 ? freqComparison : a.compareTo(b);
            }
        };

        // Create a TreeMap with the custom Comparator
        TreeMap<Integer, Integer> tmap2 = new TreeMap<>(frequencyComparator);

        // Populate the TreeMap with frequencies
        tmap2.putAll(frequencyMap);

        // Print the sorted TreeMap
        System.out.println("TreeMap sorted by frequency:");
        System.out.println(tmap2);

    }
}
