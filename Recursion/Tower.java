public class Tower {
    public static void toh(int n, String src, String helper, String dest) {

        if (n == 1) {
            System.out.println("Transfer " + n + " disk from " + src + " to " + dest);
            return;
        }

        // transfering n-1 from source to helper
        toh(n - 1, src, dest, helper);

        // transfering nth disk from source to destination
        System.out.println("Transfer " + n + " disk from " + src + " to " + dest);

        // transfering helper to destination
        toh(n - 1, helper, src, dest);

    }

    public static void main(String args[]) {
        toh(2, "A", "B", "C");
    }
}
