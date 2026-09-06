package multithreading;

class Masterr implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Master "+i);
        }
    }
}

class Workerr implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Worker "+i);
        }
    }
}

public class Testing3 {
    public static void main(String[] args) {
        Masterr masterr = new Masterr();
        Workerr workerr = new Workerr();

        Thread master = new Thread(masterr);
        Thread worker = new Thread(workerr);

        master.setDaemon(true);

        try {
            master.start();
            worker.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
*
* - shared locks - read - any no. of threads can acquire this lock just to read but if
* any thread needs to write then it needs to wait until all shared or exclusive locks get removed
*
* - exclusive locks - write - only 1 thread can acquire at a time to modify or update, no other threads to read or write is allowed
*
* Problem in synchronized and try/catch blocks :
* - no timeout ; solution : ReentrantLock.tryLock(timeout, TimeUnit.SECONDS)
* - strict exclusive locks ; solution : ReadWriteLock splits locking into 2 lanes - read(shared) and write(exclusive)
* - Standard synchronized blocks are not interruptible - starvation, deadlock ; solution : ReentrantLock.lockInterruptibly() and
* and stampedLock introduces optimistic locking
* - synchronized blocks have capacity limit to 1 thread; so we have semaphores
*
* */
