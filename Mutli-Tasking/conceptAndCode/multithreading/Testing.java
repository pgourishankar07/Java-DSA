package multithreading;

class Worker extends Thread{
    @Override
    public void run() {
        for(int i =0;i<1000;i++){
            System.out.println("Worker");
        }
    }
}

class Master implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<1000;i++){
            System.out.println("Master");
        }
    }
}

public class Testing {
    public static void main(String[] args){
        Worker w = new Worker();
        Master m = new Master();
        Thread mthread = new Thread(m);
        try{
            w.start();
            mthread.start();
            for(int i =0;i<1000;i++){
                System.out.println("__"+i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
