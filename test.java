import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class test {
    record Pair(int s, int d) {
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(1);
        pq.add(2);
        pq.add(3);

        System.out.println(pq.contains(3));
    }

}