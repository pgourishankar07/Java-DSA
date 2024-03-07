import java.util.ArrayDeque;
import java.util.Queue;

public class _7_StkuQu {
    static class StkQue {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        boolean isEmpty() {
            return q1.isEmpty();
        }

        void push(int val) {
            q2.add(val);

            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // Swap q1 and q2
            // Queue<Integer> temp = q1;
            // q1 = q2;
            // q2 = temp;

            q1 = q2;
            q2.clear();
        }

        int pop() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return q1.poll();
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return q1.peek();
        }
    }

    public static void main(String args[]) {
        StkQue s = new StkQue();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
