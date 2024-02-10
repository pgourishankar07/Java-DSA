import java.util.*;

public class _3_LLinBuilt3 {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addFirst(1);
        list.addFirst(4);
        list.addFirst(7);
        list.addFirst(9);

        System.out.println(list.get(0));

        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
