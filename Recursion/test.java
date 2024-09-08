public class test extends Thread {

    public void run() {
        // Code that the thread will execute
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " - " + Thread.currentThread().getName());
        }
    }

    public record Student(String name, int rrn) {
    }

    public static void main(String args[]) {
        test t1 = new test();
        test t2 = new test();

        t1.start(); // Starts the thread
        t2.start();

    }
}
