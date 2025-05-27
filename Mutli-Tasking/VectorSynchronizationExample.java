import java.util.Vector;

public class VectorSynchronizationExample {
    public static void main(String[] args) {
        // Create a Vector instance
        Vector<Integer> vector = new Vector<>();

        // Thread 1: Add elements to the vector
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                vector.add(i);
                System.out.println("Thread 1 added: " + i);
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread 2: Add elements to the vector
        Thread thread2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                vector.add(i);
                System.out.println("Thread 2 added: " + i);
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print the final contents of the vector
        System.out.println("Final Vector: " + vector);
    }
}