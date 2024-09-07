import java.util.PriorityQueue;

public class test {
    public static void main(String args[]) {
        PriorityQueue<Integer> top5Queue = new PriorityQueue<>(5);

        // Add elements to the queue
        top5Queue.add(10);
        top5Queue.add(5);
        top5Queue.add(20);
        top5Queue.add(15);
        top5Queue.add(8);
        top5Queue.add(25); // This element will be discarded as the queue is full

        // The queue will now contain the top 5 elements: 5, 8, 10, 15, 20
        System.out.println(top5Queue);
    }
}
