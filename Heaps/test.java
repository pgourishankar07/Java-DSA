import java.util.PriorityQueue;

public class test {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.add(1);
        pq.add(6);
        pq.add(2);
        pq.add(9);
        pq.add(3);

        System.out.println(pq.contains(3));

        while (!pq.isEmpty()) {
            System.out.println(pq.remove()); // remove : o(logn)
        }
    }
}
