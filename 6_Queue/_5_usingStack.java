import java.util.*;

public class _5_usingStack {
    static class twoStk {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        boolean isEmpty() {
            return s1.isEmpty();
        }

        void add(int val) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(val);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        int remove() {
            int val = s1.pop();
            return val;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.peek();
        }
    }

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
