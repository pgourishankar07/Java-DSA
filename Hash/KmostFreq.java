import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KmostFreq {
    public static void main(String args[]) {

        int arr[] = { 10, 20, 20, 10, 10, 20, 5, 20 };
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            list.add(i.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int x = 0; x < k; x++) {
            for (Map.Entry<Integer, Integer> y : map.entrySet()) {
                if (list.get(x) == y.getValue()) {
                    System.out.println(y.getKey());
                }
            }
        }

    }
}
