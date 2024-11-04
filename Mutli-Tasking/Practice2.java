public class Practice2 {
    public static void main(String[] args) {
        System.out.println("Hello world");
        try {
            Thread.sleep(3000);

        } catch (Exception e) {
            // TODO: handle exception Thread.sleep pauses the current thread for a specified
            // time. If the thread is interrupted by another thread while sleeping, it
            // throws an InterruptedException.
        }
        System.out.println("Hello Bunty");
    }
}
