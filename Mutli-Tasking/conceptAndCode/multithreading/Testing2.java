package multithreading;


import java.util.ArrayList;
import java.util.List;

class Producer2 implements Runnable {

    final List<Integer> list;

    public Producer2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                System.out.println("Producer " + i + " is waiting" + list);
                while(list.size() == 100) {
                    try {
                        list.wait();
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.add(i);
                list.notify();
            }
        }
    }
}

class Consumer2 extends Thread {

    final List<Integer> list;

    public Consumer2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                System.out.println("Consumer " + i + " is waiting" + list);
                while(list.isEmpty()) {
                    try {
                        list.wait();
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.removeLast();
                list.notify();
            }
        }
    }
}

public class Testing2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Producer2 producer = new Producer2(list);
        Consumer2 consumer = new Consumer2(list);
        Thread producerThread = new Thread(producer);

        try {
            producerThread.start();
            consumer.start();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


/*
*
* if you are accesing the shared resource : list, then only inside syncrhronized block you need to write logic which touched the shared resources
* .stop() - release locks but it stops abruptly make dirty the shared resource
* the proper way to stop a thread and ensure locks are released cleanly is to use Thread.interrupt()
* */