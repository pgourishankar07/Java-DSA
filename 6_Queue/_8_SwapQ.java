import java.util.ArrayDeque;
import java.util.Queue;

public class _8_SwapQ {

    static void swap(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> temp = new ArrayDeque<>();

        // Swap the elements between q1 and temp
        while (!q1.isEmpty()) {
            temp.add(q1.poll());
        }
        // Swap the elements between q2 and q1
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        // Swap the elements between temp and q2
        while (!temp.isEmpty()) {
            q2.add(temp.poll());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);

        Queue<Integer> q2 = new ArrayDeque<>();
        q2.add(6);
        q2.add(7);
        q2.add(8);
        q2.add(9);
        q2.add(10);

        swap(q1, q2);

        while (!q1.isEmpty()) {
            System.out.println(q1.remove());
        }
        while (!q2.isEmpty()) {
            System.out.println(q2.remove());
        }
    }
}
