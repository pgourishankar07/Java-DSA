public class swap {
    static void swapNumbers(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }

    static void swapNum(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }

    public static void main(String args[]) {
        swapNumbers(5, 3);
        swapNum(5, 3);

        // Add 1 to an integer
        int x = 6;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = -4;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = 0;
        System.out.println(x + " + " + 1 + " is " + -~x);

        // convert upperCase letters to LowerCase letters
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));// prints abcdefghijklmnopqrstuvwxyz
        }

    }
}
