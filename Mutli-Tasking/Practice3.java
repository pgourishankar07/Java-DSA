import java.util.LinkedList;
import java.util.Queue;

public class Practice3 {
    static Queue<Integer> q = new LinkedList<>();

    static void enq(int i) {
        q.add(i);
    }

    static int deq() {
        if (q.isEmpty()) { // instead of if we need to use while loop so that waiting threads can recheck
                           // the condition
            try {
                q.wait(); // now the object q waits untill !empty()
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return q.remove();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            // synchronized (q) {
            for (int i = 0; i < 10; i++) {
                enq(i);
                System.out.print("Enqueue " + i + " ");
                System.out.println(q);
                // q.notifyAll(); -- notifies other threads
            }
            // }
        }

    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            // synchronized (q) {
            for (int i = 0; i < 10; i++) {
                System.out.print("Dequeue " + deq() + " ");
                System.out.println(q);
            }
            // }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();

        try {
            t1.join(); // Main Thread Wait for t1 to complete
            t2.join(); // Wait for t2 to complete
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle exception if needed
        }

        System.out.println(q); // This line will execute after both threads have finished

    }
}
