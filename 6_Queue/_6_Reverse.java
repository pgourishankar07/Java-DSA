import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Queue;

public class _6_Reverse {

    static Queue<Integer> Rev(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;

    }

    public static void main(String args[]) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // System.out.println("Original Queue :");

        Rev(q);

        System.out.println("Reversed Queue :");
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
