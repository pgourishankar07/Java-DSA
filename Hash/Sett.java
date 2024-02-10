import java.util.HashSet;
import java.util.Iterator;

public class Sett {

    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        System.out.println(set);
        System.out.println(set.contains(6));
        System.out.println(set.contains(5));
        System.out.println(set.remove(5));
        System.out.println(set.remove(5));

        @SuppressWarnings("rawtypes")
        Iterator i = set.iterator(); // irrestive of what the data type is

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
