package multithreading.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

    public static List<Integer> shared = new ArrayList<>();

    public static ReentrantLock lock = new ReentrantLock();

    public static Condition waitToProduce = lock.newCondition();
    public static Condition waitToConsume = lock.newCondition();

    public static void produce(){

        for(int i =0; i < 1000; i++){
            lock.lock();
            try{
                while(shared.size()==10){
                    waitToConsume.await();
                }
                shared.add(1);
                waitToProduce.signal();
            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println(shared);
                lock.unlock();
            }
        }

    }
    public static void consume(){
        for(int i=0;i<1000;i++){
            lock.lock();
            try{
                while(shared.isEmpty()){
                    waitToProduce.await();
                }
                shared.removeLast();
                waitToConsume.signal();
            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println(shared);
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {


        Thread producer = new Thread(()-> {
            produce();
        }
        );

        Thread consumer = new Thread(()->{
            consume();
        });

        producer.start();
        consumer.start();
    }
}
/*
* - ReentrantLock works like a single room key. The lock instance (lock) is the key, and the try block is the locked room.
What happens inside the try block: If Thread-1 calls lock.lock(), it gets the key and enters the room.
* It can safely read or modify ResourceA, ResourceB, ListC, and ListD.
What happens to other threads: If Thread-2 tries to execute code that begins with lock.lock(),
* it is forced to pause and wait. Because Thread-2 cannot get past lock.lock(), it cannot reach the lines of code inside its own try block.
*
* - always write in this pattern lock() -> try block (Critical section) -> final block (Release lock)
*
* - 2 Queues : Reentrant Q(to acquire the lock) and Condition Q(waiting q until gets signal)
* - The Condition interface (e.g., lock.newCondition()) provides a way to suspend thread execution until a specific business state becomes true.
*  It is the modern, explicit replacement for Java’s legacy Object.wait(), Object.notify(), and Object.notifyAll() monitor methods.
*
* Condition notFull = lock.newCondition(); -> internally manages a wait Queue(LL) to store the paused thread state.
* notFull.await() -> releases the lock and thread state is stored in Q, it is blocking method call - exe. stops
* notFull.signal() -> takes out the thread which is waiting for long or based on other priority  which are stored in the condition Q
*
*
* */