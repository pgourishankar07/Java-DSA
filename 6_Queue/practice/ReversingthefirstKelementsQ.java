import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReversingthefirstKelementsQ {

    public static void rev(Queue<Integer> q, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        while (!q.isEmpty()) {
            queue.add(q.remove());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            q.add(queue.remove());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);

        int k = 5;

        System.out.println(q);
        rev(q, k);
        System.out.println(q);
    }
}
