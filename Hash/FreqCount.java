import java.util.HashMap;
import java.util.Map;

public class FreqCount {
    public static void main(String args[]) {

        int arr[] = { 10, 20, 20, 10, 10, 20, 5, 20 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }

    }
}
