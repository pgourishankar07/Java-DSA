package multithreading.locks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    // Shared resource
    private final Map<String, String> cache = new HashMap<>();

    // ReadWriteLock primitive
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    // READ OPERATION: Multiple threads can execute this concurrently
    public String get(String key) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " [READ START] Reading key: " + key);
            Thread.sleep(500); // Simulate reading delay
            return cache.get(key);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            System.out.println(Thread.currentThread().getName() + " [READ END]");
            readLock.unlock();
        }
    }

    // WRITE OPERATION: Exclusive access, blocks all readers and other writers
    public void put(String key, String value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " [WRITE START] Writing key: " + key);
            Thread.sleep(1000); // Simulate writing delay
            cache.put(key, value);
            System.out.println(Thread.currentThread().getName() + " [WRITE END]");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo cacheDemo = new ReadWriteLockDemo();

        // Runnable for readers
        Runnable readTask = () -> {
            for (int i = 0; i < 2; i++) {
                cacheDemo.get("configKey");
            }
        };

        // Runnable for writers
        Runnable writeTask = () -> {
            cacheDemo.put("configKey", "UpdatedValue");
        };

        // Start multiple reader and writer threads
        new Thread(readTask, "Reader-1").start();
        new Thread(readTask, "Reader-2").start();
        new Thread(writeTask, "Writer-1").start();
        new Thread(readTask, "Reader-3").start();
    }
}

/*
* - Read Lock (Shared): If Writer-1 is not writing, Reader-1, Reader-2, and Reader-3 can acquire readLock.lock() at the same time without blocking each other.
* - Write Lock (Exclusive): When Writer-1 calls writeLock.lock(), it blocks all new readers and writers until it completes its work and calls writeLock.unlock().
*
*
*
* */