import java.util.*;

public class _5_usingStack {
    static class QuStk {
        Stack<Integer> s = new Stack<>();

        boolean isEmpty() {
            return s.isEmpty();
        }

        void push(int val) {
            if (isEmpty()) {
                s.push(val);
                return;
            }
            addToBotm(val, s);
        }

        int pop() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s.pop();
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s.peek();

        }

        void addToBotm(int data, Stack<Integer> s) {
            if (isEmpty()) {
                s.push(data);
                return;
            }
            int top = s.pop();
            addToBotm(data, s);
            s.push(top);
            return;
        }
    }

    public static void main(String args[]) {
        QuStk q = new QuStk();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        while (!q.isEmpty()) {
            System.out.println(q.pop());
        }
    }
}
