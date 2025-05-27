
public class basics {
    public static void main(String args[]) {
        System.out.println(4 & 1);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print((char) (ch - 32)); // Convert to uppercase
        }
        // a = 97 => 1011111
        // _ = 95 => 1100001
        // a & _ => 1000001 => 65

        System.out.println();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));
        }
    }
}
