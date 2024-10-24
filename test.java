import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;

public class test {

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.add(1);
        stk.add(2);
        stk.add(3);

        System.out.println(stk.contains(1));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);

    }
}