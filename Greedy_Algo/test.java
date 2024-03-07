import java.util.PriorityQueue;

class test {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(3);
        pq.offer(2);

        System.out.println(pq);
    }
}