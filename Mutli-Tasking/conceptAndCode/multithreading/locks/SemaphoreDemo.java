package multithreading.locks;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    // Create a Semaphore with 3 permits (max 3 concurrent threads allowed)
    private static final Semaphore semaphore = new Semaphore(3);

    static class Worker implements Runnable {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is waiting for a permit...");

                // 1. Acquire permit (Blocks if no permits are available)
                semaphore.acquire();
                System.out.println(name + " -> PERMIT ACQUIRED! Working... (Available permits: "
                        + semaphore.availablePermits() + ")");

                // Simulate performing work
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 2. Always release permit in the finally block
                System.out.println(name + " <- Releasing permit.");
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        // Spawn 5 threads competing for 3 available permits
        for (int i = 1; i <= 5; i++) {
            new Thread(new Worker("Worker-" + i)).start();
        }
    }
}

// The Protected Code Section: The lines of code inside the try block—specifically
// where the thread sleeps (Thread.sleep(1000))—represent access to a simulated shared resource
// (such as a database connection pool, a network socket, or a rate-limited API).