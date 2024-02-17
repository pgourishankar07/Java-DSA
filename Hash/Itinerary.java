import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Itinerary {

    public static void Solution(HashMap<String, String> map) {
        Set<String> from = map.keySet();
        Set<String> to = new HashSet<>();

        // inserting all To places
        for (String str : from) {
            to.add(map.get(str));
        }

        // checking which is the start place
        String start = "";
        for (String str : from) {
            if (!to.contains(str)) {
                start = str;
            }
        }

        System.out.print(start);

        while (map.containsKey(start)) {
            System.out.print("->" + map.get(start));
            start = map.get(start);
        }

    }

    public static void main(String args[]) {
        HashMap<String, String> map = new HashMap<>();

        map.put("Chennai", "Banglore");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        Solution(map);

    }
}
