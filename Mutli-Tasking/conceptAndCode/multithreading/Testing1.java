package multithreading;


class Producer extends Thread{
    @Override
    public void run() {
        for(int i =0;i<100;i++){
            SharedResource1.produce();
        }
    }
}

class Consumer implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<100;i++){
            SharedResource1.consume();
        }
    }
}

public class Testing1 {
    public static void main(String[] args) {

        Producer p = new Producer();
        Consumer c = new Consumer();
        Thread cthread = new Thread(c);
        try {
            p.start();
            cthread.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

// sleep(), wait() -- write inside try catch block, exceptions are thrown, so we need to handle them.

/*
*
* - example for monitor locks :
* - 1 object - 1 restroom
* - monitor lock - 1 door lock for that restroom
* - synchronized blocks - this block of code can be : piss, pee, poop, wash hands, shaving etc
* - 1 thread - 1 person
*
* - in java, monitor locals are reentrant, this means if a thread already holds the lock for an object(restroom),
* - it is allowed to enter other synchronizd blocks(piss,pee,poop,shaving) that use the same lock without getting blocked
* - this can block other threads infinite or anything can happen which can leasd to Deadlock or starvation - that is why we have Locks and Semaphores
*
* Always use 'while' instead of 'if' for thread condition - context switch happens in middle of the code
*
* */