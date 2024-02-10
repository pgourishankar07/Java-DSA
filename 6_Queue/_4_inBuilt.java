import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class _4_inBuilt {
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        System.out.println();
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        while (!q1.isEmpty()) {
            System.out.println(q1.remove());
        }

    }
}
