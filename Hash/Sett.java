import java.rmi.server.SocketSecurityException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sett {

    public static void main(String args[]) {

        // insert order is not maintained it will be arranged in any order
        // implementation using HashMap
        // null is also allowed to insert
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(3);
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
        System.out.println();

        for (Integer n : set) {
            System.out.println(n);
        }

        // ______________// ______________// ______________// ______________//

        // insert order is maintained
        // null is allowed but in TreeSet is not allowed because it cant sort

        LinkedHashSet<Integer> lset = new LinkedHashSet<>();

        lset.add(5);
        lset.add(4);
        lset.add(1);
        lset.add(null);
        lset.add(2);

        System.out.println(lset);
        // ______________// ______________// ______________// ______________//

        // Treeset is used for sorted order and u cant add null
        TreeSet<Integer> tset = new TreeSet<>();

        tset.add(5);
        tset.add(2);
        tset.add(6);
        tset.add(1);
        tset.add(3);

        System.out.println(tset);

    }
}