import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class test {

    public static Queue<Integer> reverseK(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int c = 0;
        // int k = 4;
        if (!q.isEmpty()) {

            while (c != k) {
                s.push(q.remove());
                c++;
            }
        }

        Queue<Integer> newQ = new ArrayDeque<>();
        while (!s.isEmpty()) {
            newQ.add(s.pop());
        }
        while (!q.isEmpty()) {
            newQ.add(q.remove());
        }
        return newQ;
    }

    public static void main(String args[]) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q = reverseK(q, 4);
        System.out.println("After Reversing :");

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        System.out.println("___________");

        TreeMap<String, Integer> temp = new TreeMap<>();
        temp.put("Gouri", 92);
        temp.put("Rupali", 32);
        temp.put("Niru", 52);

    }
}
