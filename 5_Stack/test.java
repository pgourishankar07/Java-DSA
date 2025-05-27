import java.util.LinkedList;
import java.util.Queue;

public class test {
    static void add(int n, Queue<Integer> q) {
        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty()) {
            temp.add(q.poll());
        }
        q.add(n);
        while (!temp.isEmpty()) {
            q.add(temp.poll());
        }
    }

    static int remove(Queue<Integer> q) {
        if (q.isEmpty()) {
            return -1;
        } else {
            return q.poll();
        }
    }

    static int peek(Queue<Integer> q) {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        add(1, q);
        add(2, q);
        add(3, q);

        System.out.println(remove(q));
        System.out.println(remove(q));
        System.out.println(peek(q));
        System.out.println(remove(q));

    }
}
