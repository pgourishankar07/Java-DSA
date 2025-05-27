import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Practice1 {

    static class Thread1 extends Thread { // using class Thread
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + " " + i); // name,priority ,parent Thread
            }
        }
    }

    static class Thread2 implements Runnable { // using interface Runnable and use Thread class to create Thread
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + " --- " + i);
            }

        }
    }

    public static void main(String[] args) {

        System.out.println("Main Thread Starts");

        // Thread1 t1 = new Thread1();
        Thread t1 = new Thread(new Thread1(), "t1");
        // Thread t1 = new Thread(new Thread1(()->{..code}), "t1");

        System.out.println("Child user thread Starts");
        t1.start();

        // t1.setDaemon(true); // setting it as daemon thread - this will stop when all
        // user threads stops exe.

        Thread t2 = new Thread(new Thread2(), "t2");

        t2.start();

        System.out.println("Main Thread Ends");

    }
}

/*
 * Now there are two threads - Main and user created t1 both exe. simutaneously
 * (cant predict o/p)
 */