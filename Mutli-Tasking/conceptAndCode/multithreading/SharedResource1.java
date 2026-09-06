package multithreading;

import java.util.ArrayList;
import java.util.List;

public class SharedResource1 {

    public static List<Integer> list = new ArrayList<>();

    public static synchronized void produce(){
        while(list.size() == 10){
            try {
                SharedResource1.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        list.add(1);
        System.out.println("After Producing : " + list);
        SharedResource1.class.notify();
    }

    public static synchronized void consume(){
        while(list.isEmpty()){
            try {
                SharedResource1.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        list.removeLast();
        System.out.println("After Consuming : " + list);
        SharedResource1.class.notify();
    }
}
