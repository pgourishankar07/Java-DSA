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
        asteroidCollision t1 = new asteroidCollision();
        asteroidCollision t2 = new asteroidCollision();

        t1.start(); // Starts the thread
        t2.start();

    }
}
