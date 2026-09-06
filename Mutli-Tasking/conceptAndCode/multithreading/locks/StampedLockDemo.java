package multithreading.locks;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    private static int sharedData = 0;
    private static final StampedLock lock = new StampedLock();

    // 1. Optimistic Read (Fast, non-blocking)
    public static void readData() {
        // Obtain an optimistic read stamp (does not block writers)
        long stamp = lock.tryOptimisticRead();
        int currentData = sharedData;

        // Check if a writer acquired a lock while we were reading
        if (!lock.validate(stamp)) {
            // Fallback: Acquire a traditional pessimistic read lock
            stamp = lock.readLock();
            try {
                currentData = sharedData;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " Read: " + currentData);
    }

    // 2. Write Operation (Exclusive lock)
    public static void writeData(int value) {
        // Acquire an exclusive write lock
        long stamp = lock.writeLock();
        try {
            sharedData = value;
            System.out.println(Thread.currentThread().getName() + " Wrote: " + value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        Runnable reader = StampedLockDemo::readData;
        Runnable writer = () -> writeData(42);

        new Thread(reader, "Reader-1").start();
        new Thread(writer, "Writer-1").start();
        new Thread(reader, "Reader-2").start();
    }
}

// Stamps as Tokens: Every locking method returns a long value (a stamp) that acts as a ticket to unlock or validate the lock.
// Optimistic Reading: lock.tryOptimisticRead() allows threads to read data without acquiring a real lock. If lock.validate(stamp) returns false,
// it means a writer modified the value mid-read, triggering a fallback to a standard readLock().