import java.util.ArrayDeque;
import java.util.Deque;

public class _9_Deque {
    public static void main(String args[]) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);

        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        dq.addLast(4);
        dq.addLast(5);
        dq.addLast(6);

        while (!dq.isEmpty()) {
            System.out.println(dq.removeFirst());
        }
    }
}
